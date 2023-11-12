package com.example.geektrust;

// Database imports
import com.example.geektrust.database.DriversDatabase;
import com.example.geektrust.database.RidersDatabase;
import com.example.geektrust.database.RidesDatabase;

// Model imports
import com.example.geektrust.models.Driver;
import com.example.geektrust.models.Ride;
import com.example.geektrust.models.Rider;

import com.example.geektrust.utils.Constants;
import com.example.geektrust.utils.Logger;
import com.example.geektrust.utils.RideStatus;

public class IOManager {
    private DriversDatabase driversDb;
    private RidersDatabase ridersDb;
    private RidesDatabase ridesDb;
    private Logger logger;


    public IOManager() {
        System.out.println("[INIT] IOManager");
        driversDb = new DriversDatabase();
        ridersDb = new RidersDatabase();
        ridesDb = new RidesDatabase();
        logger = new Logger();
    }

    public void processInputLine(String inputLine){
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

    private void billCommand(String rideId) {
    }

    private void stopRideCommand(String rideId, Integer destXCord, Integer destYCord, Integer timeTaken) {
        // DOCS: Checking if rideId do not exist case
        if(!ridesDb.isExists(rideId)){
            logger.log("INVALID_RIDE");
            return;
        }

        // DOCS: Ride already stopped case
        Ride rideObj = ridesDb.getRideById(rideId);
        if(rideObj.getCurrentRideStatus() == RideStatus.STOP){
            logger.log("INVALID_RIDE");
            return;
        }

        rideObj.setCurrentRideStatus(RideStatus.STOP);
        Driver driverObj = driversDb.getDriverById(rideObj.getRideDriverId());
        driverObj.stopRide(destXCord,destYCord );
        rideObj.stopRide(destXCord,destYCord,timeTaken);
    }

    private void startRideCommand(String rideId, Integer matchNumToAccept, String riderId) {
        // DOCS: Checking if rideId already exists case
        if(ridesDb.isExists(rideId)){
            logger.log("INVALID_RIDE");
            return;
        }

        Rider riderObj = ridersDb.getRiderById(riderId);
        if(!riderObj.isValidMatchNum(matchNumToAccept)){
            logger.log("INVALID_RIDE");
            return;
        }

        Ride newRide = new Ride(rideId);
        String driverId = riderObj.getDriverId(matchNumToAccept);
        newRide.startRide(riderId,driverId);

        logger.log("RIDE_STARTED " + rideId);
    }

    private void matchCommand(String riderId) {

    }

    private void addRiderCommand(String riderId, Integer xCord, Integer yCord) {
        Rider riderObj = new Rider(riderId,xCord,yCord);
        ridersDb.putRiderById(riderId, riderObj);
    }

    public void addDriverCommand(String driverId, Integer xCord, Integer yCord){
        Driver driverObj = new Driver(driverId, xCord, yCord);
        driversDb.putDriverById(driverId,driverObj);
    }
}
