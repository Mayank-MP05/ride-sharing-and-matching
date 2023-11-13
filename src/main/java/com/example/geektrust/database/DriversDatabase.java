package com.example.geektrust.database;

import com.example.geektrust.models.Driver;
import com.example.geektrust.utils.DriverStatus;

import java.util.ArrayList;
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

    public ArrayList<Driver> getAvailableDrivers(){
        ArrayList<Driver> allDrivers = new ArrayList<>(allDriversDb.values());
        ArrayList<Driver> availableDrivers = new ArrayList<>();
        for(Driver driver: allDrivers){
            if(driver.getDriverCurrentStatus() == DriverStatus.AVAILABLE){
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }
}
