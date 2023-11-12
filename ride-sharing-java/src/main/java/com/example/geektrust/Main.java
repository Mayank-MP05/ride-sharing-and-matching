package com.example.geektrust;

import com.example.geektrust.utils.Constants;
import com.example.geektrust.IOManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public void Main() {
        System.out.println("constructor call");
    }
    public static void main(String[] args) {
        IOManager ioManager = new IOManager();
        try {
            // FIXME: Later on change this to args[0]
            String inputFileToRead = "sample_input/input1.txt";
            FileInputStream fis = new FileInputStream(inputFileToRead);
            Scanner sc = new Scanner(fis); // file to be scanned
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                ioManager.processInputLine(inputLine);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println("IOException: Error reading input file");
            System.out.println(e);
        } catch (Exception e){
            System.out.println("Undetected exception");
            System.out.println(e);
        }
    }
}
