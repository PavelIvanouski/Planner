package by.planner.domain.features;

import by.planner.domain.exceptions.TaskCheckedException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Scanner;

public class ReturnFeature{

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

    public static String returnTwoDateDifference(LocalDateTime start, LocalDateTime end){
        Duration duration = Duration.between(start, end);
        if (duration.toSeconds() < 0) {
            return "Deadline has already arrived!";
        }
        long allSeconds = duration.getSeconds();
        long days = allSeconds / (24 * 60 * 60);
        long rest = allSeconds - (days * 24 * 60 * 60);
        long hours = rest / (60 * 60);
        long rest1 = rest - hours * (60 * 60);
        long min = rest1 / 60;
        long sec = allSeconds % 60;
        String srtTemplate = "%d day(s) %d hour(s) %d min %d sec to deadline.";
        String str = String.format(srtTemplate, days, hours, min, sec);
        return str;
    }

    public static LocalDateTime enterTaskDate(Scanner scanner, LocalDateTime currentDate){
        LocalDateTime taskDate;
        int year = checkNumber(scanner, currentDate.getYear(), currentDate.getYear() + 1, "year");
        int month = checkNumber(scanner, currentDate.getMonthValue(), 12, "month");
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        int day = checkNumber(scanner, currentDate.getDayOfMonth(), daysInMonth, "day");
        int hour = checkNumber(scanner, currentDate.getHour(), 23, "hour");
        int minute = checkNumber(scanner, currentDate.getMinute(), 59, "minute");
        taskDate = LocalDateTime.of(year, month, day, hour, minute);
        return taskDate;
    }

    public static int checkNumber(Scanner scanner, int minBound, int maxBound, String datePar){
        int number;
        do {
            System.out.println("Enter " + datePar + " from [" + minBound + ";" + maxBound + "]:");
            while (!scanner.hasNextInt()) {
                System.out.println("It is not an integer  number! Try again:");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < minBound || number > maxBound);

        return number;
    }

}
