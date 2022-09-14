package com.peaksoft;

import java.nio.file.Path;

import static com.peaksoft.Main.*;
import static com.peaksoft.Utils.readFile;


public class Driver {
    private int id;
    private String name;
    private String truck;

    public Driver() {
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getTruck() {return truck;}

    public void setTruck(String truck) {this.truck = truck;}

    public static Driver createDriver(int id, String name, String truckName){
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.truck = truckName;

        return driver;
    }

    public static void printDriver(Path path) {

            Driver[] drivers = gson.fromJson(readFile(PATH_DRIVER), Driver[].class);
            System.out.println("\n        Driver Info       ");
            System.out.println("________________________________");
            System.out.println("|id |     Driver    |    Bus   | ");
            System.out.println("|______________________________|");

            for (Driver driver : drivers) {
                System.out.println(driver);
            }
            System.out.println("--------------------------------\n");
        }

        @Override
        public String toString () {
            return "" +
                    "| " + id +
                    " |     " + name +
                    "     |  " + truck + "        |"
                    ;
        }
    }