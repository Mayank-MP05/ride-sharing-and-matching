package com.example.geektrust.utils;

public class Constants {
    public static final String solvedBy = "Mayank Pachpande";
    public static final boolean DEBUG_MODE = true;

    // Command related constants
    public static final String ADD_DRIVER = "ADD_DRIVER";
    public static final String ADD_RIDER = "ADD_RIDER";
    public static final String MATCH = "MATCH";
    public static final String START_RIDE = "START_RIDE";
    public static final String STOP_RIDE = "STOP_RIDE";
    public static final String BILL = "BILL";

    // Ride level configs
    public static final Integer MAX_MATCHES = 5;
    public static final Integer MIN_MATCHES = 1;

    // Bill levels configs constants
    /*
    * Generate bill of the ride based on below rules:
    * - A base fare of ₹50 is charged for every ride.
    * - An additional ₹6.5 is charged for every kilometer traveled.
    * - An additional ₹2 is charged for every minute spent in the ride.
    * - A service tax of 20% is added to the final amount.
    */
    public static final Double BASE_FARE = 50.00;
    public static final Double PER_KM_FARE = 6.50;
    public static final Double PER_MIN_FARE = 2.0;
    public static final Double SERVICE_TAX_IN_PERCENTAGE = 20.0;

    // Match related settings
    public static final Double MATCH_RADIUS = 5.0;
    public static final Integer MAX_DRIVERS_TO_MATCH = 5;

}
