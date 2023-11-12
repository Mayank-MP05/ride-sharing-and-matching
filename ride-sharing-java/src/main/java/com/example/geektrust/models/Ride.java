package com.example.geektrust.models;

import com.example.geektrust.utils.RideStatus;

public class Ride {
    private String rideId;
    private Integer startingXCord;
    private Integer startingYCord;
    private Integer endingXCord;
    private Integer endingYCord;

    private String rideDriverId;

    public String getRideDriverId() {
        return rideDriverId;
    }

    public String getRideRiderId() {
        return rideRiderId;
    }

    private String rideRiderId;

    private Integer timeTaken;

    private RideStatus currentRideStatus;

    private Integer billGenerated;

    public Ride(String rideId) {
        this.rideId = rideId;
    }

    public void startRide(String rideRiderId, String rideDriverId){
        this.rideDriverId = rideDriverId;
        this.rideRiderId = rideRiderId;

        this.currentRideStatus = RideStatus.START;
    }

    public void stopRide(Integer destinationXCord,Integer destinationYCord,Integer timeTaken){
        this.endingXCord = destinationXCord;
        this.endingYCord = destinationYCord;

        this.timeTaken = timeTaken;
    }

    public RideStatus getCurrentRideStatus() {
        return currentRideStatus;
    }

    public void setCurrentRideStatus(RideStatus currentRideStatus) {
        this.currentRideStatus = currentRideStatus;
    }

    /**
     * Generate bill of the ride based on below rules:
     * - A base fare of ₹50 is charged for every ride.
     * - An additional ₹6.5 is charged for every kilometer traveled.
     * - An additional ₹2 is charged for every minute spent in the ride.
     * - A service tax of 20% is added to the final amount.
     */
    public void generateBill(){

    }

}
