package by.planner.util;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateUtil{

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

}
