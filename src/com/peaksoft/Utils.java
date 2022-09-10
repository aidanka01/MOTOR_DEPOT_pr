package com.peaksoft;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Utils {
    public static void writeFile(String object, Path path){
        Path write = Paths.get(String.valueOf(path));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (Exception e) {
            e.getMessage();
        }

    }
    public static String readFile(Path path){
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(path));
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
