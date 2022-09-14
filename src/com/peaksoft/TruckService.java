package com.peaksoft;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.peaksoft.Truck.State.ROUTE;

public class TruckService {
    static Scanner scanner = new Scanner(System.in);

    public static void changeTruck(Truck[] trucks, Driver[] drivers) {
        while (true) {
            try {
                System.out.println("=======| Select the TRUCK |======");
                int truckId = scanner.nextInt();
                if (truckId == 0) {
                    break;
                }

                Truck chooseTruck = getTruckByID(trucks, truckId);
                System.out.println("\nYou selected: " + chooseTruck);
                System.out.println("\nChoose the action, what do you want:\n" +
                        " 0 = Exit the system\n" +
                        " 1 = Change the driver\n" +
                        " 2 = Start driving\n" +
                        " 3 = Go to Repair\n");


                int actionNum = scanner.nextInt();
                if (actionNum == 0) {
                    break;
                }
                switch (actionNum) {
                    case 1 -> changeDriver(chooseTruck, drivers);
                    case 2 -> startDriving(chooseTruck);
                    case 3 -> startRepair(chooseTruck);
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void changeDriver(Truck truck, Driver[] drivers) {
        if (truck.getState().equals(ROUTE)) {
            System.out.println("Truck is on ROUTE, you can't 'change driver' ");
        } else if (truck.getState().equals(Truck.State.REPAIR)) {
            System.out.println("Truck is on REPAIR, you can't change the driver! ");
        } else {

            Driver driver = getFreeDriver(drivers);
            truck.setDriver(driver);
            driver.setTruck(truck.getName());
            System.out.println("Now this truck " + truck.getName() +
                    "drives Driver " + driver.getName());


            if (truck.getState().equals(Truck.State.BASE)) {
                //   if (truck.getDriver().equals(Truck.State.BASE)) {
                Driver driver1 = (truck.getDriver());
                driver1.setTruck(" ");
            }
            System.out.println("Now this truck " + truck.getName() +
                    "drives Driver " + driver.getName());
        }
    }


    public static Truck getTruckByID(Truck[] trucks, int id) {

        return Arrays.stream(trucks)
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Truck is not found"));

    }

    public static Driver getFreeDriver(Driver[] drivers) {
        return Arrays.stream(drivers)
                .filter(d -> d.getTruck().equals(""))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Sorry, no free drivers"));
    }

    public static void startDriving(Truck truck) {
        if (truck.getState().equals(ROUTE)) {
            System.out.println("Truck is already on ROUTE");
        } else if (truck.getDriver() == null) {
            System.out.println("Sorry no free Drivers");
        } else {
            truck.setState(ROUTE);
            System.out.println("Truck is successfully on ROUTE!");
        }
    }

    public static void startRepair(Truck truck) {
        if (truck.getState().equals(Truck.State.REPAIR)) {
            System.out.println("Truck is already on Repair");
        } else {
            truck.setState(Truck.State.REPAIR);
            System.out.println("Truck is on Repair");


        }
    }
}
