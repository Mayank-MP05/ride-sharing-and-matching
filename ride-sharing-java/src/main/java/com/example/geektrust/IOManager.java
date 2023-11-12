package com.example.geektrust;

import com.example.geektrust.utils.Constants;

public class IOManager {
    public IOManager() {
        System.out.println("[INIT] IOManager");
    }

    public static void processInputLine(String inputLine){
        String[] tokensList;
        String commandToken;
        String riderId, driverId, rideId;
        Integer xCord, yCord, matchNumToAccept, timeTaken,destXCord,destYCord;

        tokensList = inputLine.split(" ");
        if(tokensList.length != 0){
            commandToken = tokensList[0];
            switch (commandToken){
                case Constants.ADD_DRIVER:
                    driverId = tokensList[1];
                    xCord = Integer.parseInt(tokensList[2]);
                    yCord = Integer.parseInt(tokensList[3]);
                    addDriverCommand(driverId,xCord,yCord);
                    break;
                case Constants.ADD_RIDER:
                    riderId = tokensList[1];
                    xCord = Integer.parseInt(tokensList[2]);
                    yCord = Integer.parseInt(tokensList[3]);
                    addRiderCommand(riderId,xCord,yCord);
                    break;
                case Constants.MATCH:
                    riderId = tokensList[1];
                    matchCommand(riderId);
                    break;
                case Constants.START_RIDE:
                    rideId = tokensList[1];
                    matchNumToAccept = Integer.parseInt(tokensList[2]);
                    riderId = tokensList[3];
                    startRideCommand(rideId,matchNumToAccept,riderId);
                    break;
                case Constants.STOP_RIDE:
                    rideId = tokensList[1];
                    destXCord = Integer.parseInt(tokensList[2]);
                    destYCord = Integer.parseInt(tokensList[3]);
                    timeTaken = Integer.parseInt(tokensList[4]);
                    stopRideCommand(rideId,destXCord, destYCord,timeTaken);
                    break;
                case Constants.BILL:
                    rideId = tokensList[1];
                    billCommand(rideId);
                    break;
                default:
                    System.out.println("Invalid input token");
                    break;
            }
        }
    }

    private static void billCommand(String rideId) {
    }

    private static void stopRideCommand(String rideId, Integer destXCord, Integer destYCord, Integer timeTaken) {
    }

    private static void startRideCommand(String rideId, Integer matchNumToAccept, String riderId) {
    }

    private static void matchCommand(String riderId) {
    }

    private static void addRiderCommand(String riderId, Integer xCord, Integer yCord) {
    }

    public static void addDriverCommand(String driverId,Integer xCord,Integer yCord){

    }


}
