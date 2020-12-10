package by.planner.database;

import by.planner.util.SerializationUtil;

import java.util.ArrayList;
import java.util.List;

public class DB{
    public static void SaveDb(List arrayList){
        SerializationUtil.serializeObject(arrayList, SerializationUtil.FILENAME);
        System.out.println("Tasks were saved.");
    }


}
