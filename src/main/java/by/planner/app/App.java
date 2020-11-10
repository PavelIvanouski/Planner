package by.planner.app;

import by.planner.domain.Category;
import by.planner.domain.Priority;
import by.planner.domain.TaskToPerform;
import by.planner.domain.TaskType;


public class App{
    public static void main(String[] args){
        TaskToPerform.Builder<Integer> builder = new TaskToPerform.Builder<Integer>();
        builder.withName("To watch a movie");
        builder.withCategory(Category.CHILLOUT);
        builder.withPriority(Priority.OPTIONAL);
        builder.withTaskType(TaskType.ONE_TIME);
        builder.withDateOfComplition("09/11");
        builder.withTimeToComplete(120);
        builder.withId(13133);
//        builder.withId("PPPP123")
        TaskToPerform oneTimeTaskChill = builder.build();
        System.out.println(oneTimeTaskChill);

        TaskToPerform.Builder<String> builder1 = new TaskToPerform.Builder<String>();
        TaskToPerform repeatableTask = builder1.withName("To wash the dishes").withCategory(Category.HOMEWORK).
                withPriority(Priority.IMPORTANT).withTaskType(TaskType.REPEATABLE).
                withDateOfComplition("09/11").withTimeToComplete(20).withNumberOfRepeats(3).withId("pfdfdf").build();
        System.out.println(repeatableTask);

        System.out.println();
        int allTime = 0;

        allTime += oneTimeTaskChill.perform();
        System.out.println("Spent time: " + allTime + " min.");
        allTime += oneTimeTaskChill.perform();
        System.out.println("Spent time: " + allTime + " min.");
        allTime += repeatableTask.perform();
        System.out.println("Spent time: " + allTime + " min.");
    }
}
