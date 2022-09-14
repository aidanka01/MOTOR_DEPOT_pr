package com.peaksoft;
import java.nio.file.Path;
import static com.peaksoft.Main.*;
import static com.peaksoft.Utils.readFile;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static  Truck createTruck(int id, String name, Driver driver, State state){
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
         System.out.println("________________________________________");
         System.out.println("| id |   Truck   |    Driver   |  State|");
         System.out.println("|______________________________________|");

         for (Truck truck : trucks) {
             System.out.println(truck);
         }
         System.out.println("----------------------------------------");
     }

    @Override
    public String toString() {
        return "" +
                "| " + id +
                "  |  " + name   +
                "  |   " + driver   +
                "      | " + state + "  |"
                ;
    }

    public enum State {
        BASE,
        ROUTE,
        REPAIR;
    }
}
