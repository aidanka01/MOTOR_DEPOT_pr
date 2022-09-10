package com.peaksoft;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.peaksoft.Main.*;
import static com.peaksoft.Utils.readFile;


public class Driver {
    private int id;
    private String name;
    private String truckName;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getTruckName() {return truckName;}

    public void setTruckName(String truckName) {this.truckName = truckName;}

    public static Driver createDriver(int id, String name, String truckName){
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truckName = truckName;

        return driver;
    }

    public static void printDriver(Path path) {
        Driver[] drivers = gson.fromJson(readFile(PATH_DRIVER), Driver[].class);
        System.out.println("        Driver Info       ");
        System.out.println("________________________________");
        System.out.println("|id |     Driver   |    Bus    | ");
        System.out.println("|______________________________|");

        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println("________________________________");
    }

        @Override
        public String toString () {
            return "" +
                    "| " + id +
                    " |     " + name +
                    "     |  " + truckName + "        |"
                    ;
        }
    }