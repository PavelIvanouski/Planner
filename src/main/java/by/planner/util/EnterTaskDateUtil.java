package by.planner.util;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Scanner;

public class EnterTaskDateUtil{

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
