package by.planner.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationUtil{

    public static Object deserializeObject(String filename){
        Object returnObject = null;
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            returnObject = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An exception occurred during deserialization.");
            e.printStackTrace();
        }
        return returnObject;
    }

}
