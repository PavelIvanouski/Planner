package by.planner.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Scanner;

public class EnterTaskDateUtil{

    public static LocalDateTime enterTaskDate(Scanner scanner, LocalDateTime currentDate){
        LocalDateTime taskDate;

        int currentYear = currentDate.getYear();
        int year = checkNumber(scanner, currentYear, currentYear + 1, "year");

        int currentMonth = currentDate.getMonthValue();
        int leftBoundMonth = (year == currentYear) ? currentMonth : 1;
        int month = checkNumber(scanner, leftBoundMonth, 12, "month");

        int currentDay = currentDate.getDayOfMonth();
        YearMonth yearMonth = YearMonth.of(year, month);
        int leftBoundDay = (year == currentYear && month == currentMonth) ? currentDay : 1;
        int day = checkNumber(scanner, leftBoundDay, yearMonth.lengthOfMonth(), "day");

        int currentHour = currentDate.getHour();
        int leftBoundHour = (year == currentYear && month == currentMonth && day == currentDay)
                ? currentHour : 0;
        int hour = checkNumber(scanner, leftBoundHour, 23, "hour");

        int leftBoundMin = (year == currentYear && month == currentMonth && day == currentDay && hour == currentHour)
                ? (currentDate.getMinute() + 1) : 0;
        int minute = checkNumber(scanner, leftBoundMin, 59, "minute");

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
