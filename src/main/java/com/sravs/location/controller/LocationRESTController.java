package com.sravs.location.controller;

import com.sravs.location.entity.Location;
import com.sravs.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")

public class LocationRESTController {
    @Autowired
    LocationRepository locationRepository;
    @GetMapping
    public List<Location> getLocation(){
        return  locationRepository.findAll();
    }
@PostMapping
    public  Location createLocation(@RequestBody Location location) {
        return  locationRepository.save(location);
    }
    @PutMapping
    public Location saveLocation(@RequestBody Location location){
        return  locationRepository.save(location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id) {
        return locationRepository.findById(id).orElse(null);

    }


}
