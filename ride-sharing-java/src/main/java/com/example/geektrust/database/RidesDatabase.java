package com.example.geektrust.database;

import com.example.geektrust.models.Ride;

import java.util.HashMap;
import java.util.Map;

public class RidesDatabase {
    private Map<String, Ride> allRidesDb;

    public RidesDatabase() {
        allRidesDb = new HashMap<>();
    }

    public void putRideById(String rideId, Ride newRide){
        allRidesDb.put(rideId, newRide);
    }

    public Ride getRideById(String rideId){
        return allRidesDb.get(rideId);
    }

    /**
     * True or False based on presense in underlying hashmap
     * @param rideId {String}
     * @return
     */
    public boolean isExists(String rideId){
        if(allRidesDb.containsKey(rideId)){
            return true;
        }
        return false;
    }
}
