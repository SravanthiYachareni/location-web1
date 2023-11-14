package com.sravs.location.controller;

import com.sravs.location.entity.Location;
import com.sravs.location.repository.LocationRepository;
import com.sravs.location.service.LocationService;
import com.sravs.location.util.EmailUtil;
import com.sravs.location.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@Controller

public class LocationController {
    @Autowired
    LocationService locationService;
    @Autowired
    LocationRepository repository;
    @Autowired
    ReportUtil reportUtil;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    EmailUtil emailUtil;

    @RequestMapping("/showCreate")
    public String showCreate() {
        //return locationService.saveLocation(location);
        return "createLocation";
    }


    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail("sravanthiyachareni@gmail.com", "Location Saved",
        		"Location Saved Successfully and about to return a response");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.findAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        // Location location = service.getLocationById(id);
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.findAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = locationService.findLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        locationService.saveLocation(location);
        List<Location> locations = locationService.findAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }
    @RequestMapping("/generateReport")
    public String generateReport() {
        List<Object[]> data = repository.findTypeAndTypeCount();
        String path = servletContext.getRealPath("/");
        reportUtil.generatePieChart(path, data);
        return "report";
    }

}
