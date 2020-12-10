package by.planner.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationUtil{

    public static final String FILENAME = "src/main/resources/serialization/tasks.txt";

    public static void serializeObject(Object object, String filename){
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("An exception occurred during serialization.");
            e.printStackTrace();
        }
    }


}

