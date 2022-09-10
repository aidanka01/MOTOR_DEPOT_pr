package com.peaksoft;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson =BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truckInfo.gson");

    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.createTruck(1, "MAN XP ", "", Truck.State.BASE),
                Truck.createTruck(2, "JAC GM ", "", Truck.State.BASE),
                Truck.createTruck(3, "IVACO Y", "", Truck.State.BASE),
        };

        //String gson1 = gson.toJson(trucks);
        //  writeTruck(gson1);

        Truck[] trucks2 = gson.fromJson(readTruck(), Truck[].class);
        System.out.println("           Truck Info       ");
        System.out.println("_________________________________");
        System.out.println(" # |   Truck   | Driver |  State  ");
        System.out.println("_________________________________");

        for (Truck truck : trucks){
            System.out.println(truck);
        }

    }
    private static void writeTruck(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    private static String readTruck() {
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
        return json;

    }
}