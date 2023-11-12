package com.example.geektrust.models;

import com.example.geektrust.utils.DriverStatus;
import com.example.geektrust.utils.RideStatus;

public class Driver {
    private String driverId;
    private Integer xCord;
    private Integer yCord;

    private DriverStatus driverCurrentStatus;

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

}
