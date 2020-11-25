package by.planner.app;

import by.planner.domain.*;

import java.util.*;


public class App{
    public static void main(String[] args){
        TaskToPerform.Builder<Integer> builder1 = new TaskToPerform.Builder<>();
        builder1.withName("To watch a movie");
        builder1.withCategory(Category.CHILLOUT);
        builder1.withPriority(Priority.OPTIONAL);
        builder1.withTaskType(TaskType.ONE_TIME);
        builder1.withDateOfComplition("09/11");
        builder1.withTimeToComplete(120);
        builder1.withId(13133);
        TaskToPerform<Integer> Task1 = builder1.build();

        TaskToPerform.Builder<Integer> builder2 = new TaskToPerform.Builder<>();
        builder2.withName("To sleep");
        builder2.withCategory(Category.CHILLOUT);
        builder2.withPriority(Priority.IMPORTANT);
        builder2.withTaskType(TaskType.ONE_TIME);
        builder2.withDateOfComplition("09/11");
        builder2.withTimeToComplete(120);
        builder2.withId(13133);
        TaskToPerform<Integer> Task2 = builder2.build();

        TaskToPerform.Builder<Integer> builder3 = new TaskToPerform.Builder<>();
        builder3.withName("To sleep");
        builder3.withCategory(Category.CHILLOUT);
        builder3.withPriority(Priority.IMPORTANT);
        builder3.withTaskType(TaskType.ONE_TIME);
        builder3.withDateOfComplition("09/11");
        builder3.withTimeToComplete(10);
        builder3.withId(16);
        TaskToPerform<Integer> Task3 = builder3.build();


        List<TaskToPerform> taskToPerformList = new ArrayList<>();
        taskToPerformList.add(Task1);
        taskToPerformList.add(Task2);
        taskToPerformList.add(Task3);
        taskToPerformList.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        String pressedKey = "";
        while (!pressedKey.equals("x")) {
            System.out.println();
            System.out.println("Press \'p\' to print; \'a\' to add; \'s\' to sort; \'x\' to exit");
            pressedKey = scanner.nextLine();
            switch (pressedKey) {
                case "p":
                    System.out.println("Pressed 'p':");
                    System.out.println("Print:");
                    taskToPerformList.forEach(System.out::println);
                    break;
                case "a":
                    System.out.println("Pressed 'a':");
                    TaskToPerform.addNewTask(scanner, taskToPerformList);
                    break;
                case "s":
                    System.out.println("Pressed 's':");
                    System.out.println("Sorted tasks:");
                    SortedSet<TaskToPerform> taskToPerformSortedSet = new TreeSet<>();
                    taskToPerformSortedSet.addAll(taskToPerformList);
                    taskToPerformSortedSet.forEach(System.out::println);
                    break;
                case "x":
                    System.out.println("Pressed 'x'. Exit...");
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }


//        System.out.println("Task 1 hashcode= " + Task1.hashCode());
//        System.out.println("Task 2 hashcode= " + Task2.hashCode());
//        System.out.println("Task 3 hashcode= " + Task2.hashCode());
//        System.out.println("Task1 = Task2 : " + Task1.equals(Task2));
//        System.out.println("Task1 = Task2 : " + Task1.equals(Task2));


//


    }
}
