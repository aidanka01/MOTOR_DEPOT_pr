package com.peaksoft;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson =BUILDER.setPrettyPrinting().create();
    public static final Gson gson1 =BUILDER.setPrettyPrinting().create();
    public static final Path PATH_TRUCK = Paths.get("./truckInfo.gson") ;
    public static final Path PATH_DRIVER = Paths.get("./driverInfo.gson");

    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.createTruck(1, "MAN XP ", "", Truck.State.BASE),
                Truck.createTruck(2, "JAC GM ", "", Truck.State.BASE),
                Truck.createTruck(3, "IVACO Y", "", Truck.State.BASE),
        };

        Driver[] drivers = {
                Driver.createDriver(1, "Alex ", ""),
                Driver.createDriver(2, "Henry", ""),
                Driver.createDriver(3, "Simon", ""),
        };


        String gsonTruck = gson.toJson(trucks);
        Utils.writeFile(gsonTruck, PATH_TRUCK);
        Truck.printTruck(PATH_TRUCK);

        System.out.println();

        String gsonDriver = gson.toJson(drivers);
      Utils.writeFile(gsonDriver, PATH_DRIVER);
      Driver.printDriver(PATH_DRIVER);


    }


    }
