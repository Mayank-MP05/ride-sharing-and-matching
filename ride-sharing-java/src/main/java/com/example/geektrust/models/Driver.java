package com.example.geektrust.models;

import com.example.geektrust.utils.DriverStatus;
import com.example.geektrust.utils.RideStatus;

public class Driver {
    private String driverId;
    private Integer xCord;
    private Integer yCord;
    private Double distanceFromRider;
    private DriverStatus driverCurrentStatus;
    public String getDriverId() {
        return driverId;
    }

    public double getDriverIdDouble(){
        String _driverId = this.driverId.replace("D","");
        return Double.parseDouble(_driverId);
    }

    public Driver(String driverId, Integer xCord, Integer yCord) {
        this.driverId = driverId;
        this.xCord = xCord;
        this.yCord = yCord;
        this.driverCurrentStatus = DriverStatus.AVAILABLE;
    }

    public void stopRide( Integer destXCord, Integer destYCord ){
        this.driverCurrentStatus = DriverStatus.AVAILABLE;
        this.xCord = destXCord;
        this.yCord = destYCord;
    }

    public DriverStatus getDriverCurrentStatus() {
        return driverCurrentStatus;
    }

    public void calculateDistanceFromRider(Integer riderXCord, Integer riderYCord){
        double xCordDelta = riderXCord-xCord;
        double yCordDelta = riderYCord-yCord;
        double sumOfSquares = xCordDelta*xCordDelta + yCordDelta*yCordDelta;

        double euclideanDistance = Math.sqrt(sumOfSquares);
        /*
        System.out.println("xCord: "+xCord);
        System.out.println("yCord: "+yCord);
        System.out.println("id: "+driverId);
        System.out.println("euclideanDistance: "+euclideanDistance);
        */
        this.distanceFromRider = euclideanDistance;
    }

    public double getDistanceFromRider(){
        return this.distanceFromRider;
    }
}
