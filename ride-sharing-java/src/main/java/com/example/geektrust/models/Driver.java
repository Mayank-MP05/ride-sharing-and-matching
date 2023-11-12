package com.example.geektrust.models;

import com.example.geektrust.utils.DriverStatus;

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


}
