package com.example.geektrust.database;

import com.example.geektrust.models.Driver;

import java.util.HashMap;
import java.util.Map;

public class DriversDatabase {
    private Map<String, Driver> allDriversDb;

    public DriversDatabase() {
        allDriversDb = new HashMap<>();
    }

    public void putDriverById(String driverId, Driver newDriver){
        allDriversDb.put(driverId, newDriver);
    }

    public Driver getDriverById(String driverId){
        return allDriversDb.get(driverId);
    }
}
