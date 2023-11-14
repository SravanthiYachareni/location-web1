package com.sravs.location.service;

import com.sravs.location.entity.Location;
import com.sravs.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class LocationService implements ServiceInterface {
    @Autowired
    LocationRepository locationRepository;
    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location findLocationById(int id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);

    }

    @Override
    public List<Location> findAllLocation() {
        return locationRepository.findAll();
    }
}
