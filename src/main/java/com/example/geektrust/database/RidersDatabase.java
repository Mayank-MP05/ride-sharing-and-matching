package com.example.geektrust.database;

import com.example.geektrust.models.Rider;

import java.util.HashMap;
import java.util.Map;

public class RidersDatabase {
    private Map<String, Rider> allRidersDb;

    public RidersDatabase() {
        allRidersDb = new HashMap<>();
    }

    public void putRiderById(String driverId, Rider newRider){
        allRidersDb.put(driverId, newRider);
    }

    public Rider getRiderById(String driverId){
        return allRidersDb.get(driverId);
    }
}
