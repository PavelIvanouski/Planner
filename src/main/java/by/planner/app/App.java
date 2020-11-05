package by.planner.app;

import by.planner.domain.impl.OneTimeTask;
import by.planner.domain.impl.RepeatableTask;

public class App{
    public static void main(String[] args){
        OneTimeTask oneTimeTaskChill = new OneTimeTask("To watch a movie", "Chill out",
                "Optional", "05.11", 120);

        RepeatableTask repeatableTask = new RepeatableTask("To wash the dishes", "Housework",
                "Important", "05.11", 20, 3);

        OneTimeTask oneTimeTaskStudy = new OneTimeTask("It-academy homework", "Study",
                "Important", "05.11", 60);

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
