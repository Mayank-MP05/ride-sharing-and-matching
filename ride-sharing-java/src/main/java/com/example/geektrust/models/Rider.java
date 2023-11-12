package com.example.geektrust.models;

import java.util.ArrayList;

public class Rider {
    private String riderId;

    // Rider location parameters
    private Integer xCord;
    private Integer yCord;

    private ArrayList<String> driverIdMatched = new ArrayList<>();

    public Rider(String riderId, Integer xCord, Integer yCord) {
        this.riderId = riderId;
        this.xCord = xCord;
        this.yCord = yCord;
    }
}
