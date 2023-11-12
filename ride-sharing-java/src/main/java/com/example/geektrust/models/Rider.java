package com.example.geektrust.models;

import com.example.geektrust.utils.Constants;

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

    public Integer getXCord() {
        return xCord;
    }

    public Integer getYCord() {
        return yCord;
    }
    public ArrayList<String> getMatchesArr(){
        return driverIdMatched;
    }

    /**
     * Checks if matchNum passed is valid for accepting based on min-max range and simply match arr size
     * @param matchNumToAccept
     * @return
     */
    public boolean isValidMatchNum(Integer matchNumToAccept){
        if(Constants.MIN_MATCHES <= matchNumToAccept && Constants.MAX_MATCHES >= matchNumToAccept){
            if(driverIdMatched.size() >= matchNumToAccept){
                return true;
            }
        }
        return false;
    }

    public String getDriverId(Integer matchNumToAccept){
        if(isValidMatchNum(matchNumToAccept)){
            return driverIdMatched.get(matchNumToAccept - 1);
        }
        String emptyResponse = "";
        return emptyResponse;
    }

    public void setDriverIdMatches(ArrayList<String> driverIdMatched ){
        this.driverIdMatched = driverIdMatched;
    }

}
