package com.example.geektrust;

import com.example.geektrust.utils.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DOCS: Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("sample_input/input1.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                System.out.println(inputLine);
            }
            sc.close(); // closes the scanner
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("IOException e");
        }
    }
}
