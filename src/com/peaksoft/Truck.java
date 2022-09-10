package com.peaksoft;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.peaksoft.Main.*;
import static com.peaksoft.Utils.readFile;

public class Truck {
    private int id;
    private String name;
    private String driver;
    private State state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String  driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static  Truck createTruck(int id, String name, String driver, State state){
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.state = state;

        return truck;
    }
     public static void printTruck(Path path) {
         Truck[] trucks = gson.fromJson(readFile(path), Truck[].class);
         System.out.println("           Truck Info       ");
         System.out.println("___________________________________");
         System.out.println("| id |   Truck   | Driver | State |");
         System.out.println("|_________________________________|");

         for (Truck truck : trucks) {
             System.out.println(truck);
         }
         System.out.println("|_________________________________|");
     }

  /*  public static void writeTruck(String object, Path path) {
        Path write = Paths.get(String.valueOf(path));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (Exception e) {
            e.getMessage();
        }
    }



    public static String readTruck() {
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = reader.read())!= -1) {
                json+= (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;*/




    @Override
    public String toString() {
        return "" +
                "| " + id +
                "  |  " + name   +
                "  |   " + driver   +
                "     | " + state + "  |"
                ;
    }

    public enum State {
        BASE,
        ROUTE,
        REPAIR;
    }
}
