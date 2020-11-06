package by.planner.app;

import by.planner.domain.Category;
import by.planner.domain.Priority;
import by.planner.domain.impl.OneTimeTask;
import by.planner.domain.impl.RepeatableTask;

public class App{
    public static void main(String[] args){
        OneTimeTask oneTimeTaskChill = new OneTimeTask("To watch a movie", Category.CHILLOUT,
                Priority.OPTIONAL, "05.11", 120);

        RepeatableTask repeatableTask = new RepeatableTask("To wash the dishes", Category.HOMEWORK,
                Priority.IMPORTANT, "05.11", 20, 3);

        OneTimeTask oneTimeTaskStudy = new OneTimeTask("It-academy homework", Category.STUDY,
                Priority.IMPORTANT, "05.11", 60);

        System.out.println(oneTimeTaskChill);
        System.out.println(repeatableTask);
        System.out.println(oneTimeTaskStudy);

        int allTime = 0;

        allTime += oneTimeTaskChill.perform();
        System.out.println("Spent time: " + allTime + " min.");
        allTime += oneTimeTaskChill.perform();
        System.out.println("Spent time: " + allTime + " min.");
        allTime += repeatableTask.perform();
        System.out.println("Spent time: " + allTime + " min.");
        oneTimeTaskStudy.cancel();

    }
}
