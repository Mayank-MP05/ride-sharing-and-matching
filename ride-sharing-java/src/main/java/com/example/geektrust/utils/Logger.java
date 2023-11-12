package com.example.geektrust.utils;


public class Logger {
    /**
     * This method will only log to console if its debug mode
     * @param printThis
     */
    public void debug(Object printThis){
        if(Constants.DEBUGo_MODE) {
            System.out.println(printThis);
        }
    }

    /**
     * This method will log to console even in prod mode
     * @param printThis
     */
    public void log(Object printThis){
        System.out.println(printThis);
    }
}
