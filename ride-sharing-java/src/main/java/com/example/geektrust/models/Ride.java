package com.example.geektrust.models;

import com.example.geektrust.utils.Constants;
import com.example.geektrust.utils.RideStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    private Double billGenerated;

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

    public double roundToTwoDecimals(double inputDouble){
        BigDecimal roundedValue = new BigDecimal(inputDouble);
        roundedValue = roundedValue.setScale(2, RoundingMode.HALF_UP);
        return roundedValue.doubleValue();
    }

    private double getTotalDistanceTravelled(){
        double xCordDelta = endingXCord-startingXCord;
        double yCordDelta = endingYCord-startingYCord;
        double sumOfSquares = xCordDelta*xCordDelta + yCordDelta*yCordDelta;

        double euclideanDistance = Math.sqrt(sumOfSquares);
        return roundToTwoDecimals(euclideanDistance);
    }

    /**
     * Generate bill of the ride based on below rules:
     * - A base fare of ₹50 is charged for every ride.
     * - An additional ₹6.5 is charged for every kilometer traveled.
     * - An additional ₹2 is charged for every minute spent in the ride.
     * - A service tax of 20% is added to the final amount.
     */
    public Double generateBill(){
        Double totalFare = 0.0;

        totalFare += Constants.BASE_FARE;

        totalFare += getTotalDistanceTravelled() * Constants.PER_KM_FARE;

        totalFare += timeTaken * Constants.PER_MIN_FARE;

        Double serviceTax = totalFare * Constants.SERVICE_TAX_IN_PERCENTAGE / 100;
        totalFare += serviceTax;

        totalFare = roundToTwoDecimals(totalFare);
        this.billGenerated = totalFare;
        return totalFare;
    }

}
