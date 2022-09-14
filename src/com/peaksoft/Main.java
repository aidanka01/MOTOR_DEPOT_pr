package com.peaksoft;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.peaksoft.TruckService.changeTruck;
import static com.peaksoft.Utils.writeFile;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path PATH_TRUCK = Paths.get("./truckInfo.gson");
    public static final Path PATH_DRIVER = Paths.get("./driverInfo.gson");

    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.createTruck(1, "MAN XP ", null, Truck.State.BASE),
                Truck.createTruck(2, "JAC GM ", null, Truck.State.BASE),
                Truck.createTruck(3, "IVACO Y", null, Truck.State.BASE),
                Truck.createTruck(4, "Volvo  ", null, Truck.State.BASE)
        };


        Driver[] drivers = {
                Driver.createDriver(1, "Alex ", ""),
                Driver.createDriver(2, "Henry", ""),
                Driver.createDriver(3, "Ali  ", ""),
                Driver.createDriver(4, "Bek  ", "")
        };

        Truck[] trucks1 = trucks;
        Driver[] drivers1 = drivers;
        //writeFile(gson.toJson(trucks), PATH_TRUCK);
        Truck.printTruck(PATH_TRUCK);

      // writeFile(gson.toJson(drivers), PATH_DRIVER);
      Driver.printDriver(PATH_DRIVER);

        System.out.println(" _________________________                                      ");
        System.out.println("|                         |___        ");
        System.out.println("|      I V O K E          |____\\       ");
        System.out.println("|        truck company    | I   \\D    ");
        System.out.println("|_________________________-------|     ");
        System.out.println("     (  )          (  )");
        System.out.println("");

       changeTruck(trucks1, drivers1);

        }



    }




