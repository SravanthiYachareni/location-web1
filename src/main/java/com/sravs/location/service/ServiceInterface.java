package com.sravs.location.service;

import com.sravs.location.entity.Location;

import java.util.List;

public interface ServiceInterface {

    Location saveLocation(Location location);
    Location updateLocation(Location location);
    Location findLocationById(int id);
    void  deleteLocation(Location location);
    List<Location> findAllLocation();
}
