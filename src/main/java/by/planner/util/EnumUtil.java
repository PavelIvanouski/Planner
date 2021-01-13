package by.planner.util;

import by.planner.exceptions.TaskCheckedException;
import by.planner.features.Category;
import by.planner.features.Priority;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Scanner;

public class EnumUtil{

    public static Category returnCategory(int categoryNum) throws TaskCheckedException{
        Category category;
        switch (categoryNum) {
            case 1:
                category = Category.CHILLOUT;
                break;
            case 2:
                category = Category.HOMEWORK;
                break;
            case 3:
                category = Category.STUDY;
                break;
            case 4:
                category = Category.WORK;
                break;
            default:
                category = null;
                break;
        }
        if (category == null) {
            throw new TaskCheckedException("Invalid category");
        }
        return category;
    }

    public static Priority returnPriority(int priorityNum) throws TaskCheckedException{
        Priority priorityNewTask;
        switch (priorityNum) {
            case 1:
                priorityNewTask = Priority.IMPORTANT;
                break;
            case 2:
                priorityNewTask = Priority.OPTIONAL;
                break;
            case 3:
                priorityNewTask = Priority.MIDDLE;
                break;
            default:
                priorityNewTask = null;
                break;
        }
        if (priorityNewTask == null) {
            throw new TaskCheckedException("Invalid priority");
        }
        return priorityNewTask;
    }





}
