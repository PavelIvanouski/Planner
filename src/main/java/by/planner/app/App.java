package by.planner.app;

import by.planner.domain.*;
import by.planner.features.Priority;
import by.planner.util.DateUtil;
import by.planner.util.SerializationUtil;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;


public class App{
    final static String DEADLINE_DATE = "2020-12-07T23:59:00";

    public static void main(String[] args){

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(now));
        LocalDateTime deadlineDate = LocalDateTime.parse(DEADLINE_DATE);
        System.out.println("Deadline date: " +
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(deadlineDate));

        System.out.println(DateUtil.returnTwoDateDifference(now, deadlineDate));
        System.out.println();

//        TaskToPerform.Builder<Integer> builder1 = new TaskToPerform.Builder<>();
//        builder1.withName("To watch a movie");
//        builder1.withCategory(Category.CHILLOUT);
//        builder1.withPriority(Priority.OPTIONAL);
//        builder1.withTaskType(TaskType.ONE_TIME);
//        builder1.withDateOfComplition(now);
//        builder1.withTimeToComplete(120);
//        builder1.withId(13133);
//        TaskToPerform<Integer> Task1 = builder1.build();
//
//        TaskToPerform.Builder<Integer> builder2 = new TaskToPerform.Builder<>();
//        builder2.withName("To sleep");
//        builder2.withCategory(Category.CHILLOUT);
//        builder2.withPriority(Priority.IMPORTANT);
//        builder2.withTaskType(TaskType.ONE_TIME);
//        //today evening
//        LocalDateTime todayEvening = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 00));
//        builder2.withDateOfComplition(todayEvening);
//        builder2.withTimeToComplete(120);
//        builder2.withId(13133);
//        TaskToPerform<Integer> Task2 = builder2.build();
//
//        TaskToPerform.Builder<Integer> builder3 = new TaskToPerform.Builder<>();
//        builder3.withName("To sleep");
//        builder3.withCategory(Category.CHILLOUT);
//        builder3.withPriority(Priority.IMPORTANT);
//        builder3.withTaskType(TaskType.ONE_TIME);
//        //tomorrow evening
//        builder3.withDateOfComplition(todayEvening.plusDays(1));
//        builder3.withTimeToComplete(120);
//        builder3.withId(13133);
//        TaskToPerform<Integer> Task3 = builder3.build();


        List<TaskToPerform> taskToPerformList = new ArrayList<>();

        Object deserializedObject = SerializationUtil.deserializeObject(SerializationUtil.FILENAME);
        if (deserializedObject instanceof ArrayList) {
            taskToPerformList = (ArrayList<TaskToPerform>) deserializedObject;
            System.out.println("Tasks were loaded.");
        }

//        taskToPerformList.add(Task1);
//        taskToPerformList.add(Task2);
//        taskToPerformList.add(Task3);

        taskToPerformList.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        String pressedKey = "";
        while (!pressedKey.equals("x")) {
            System.out.println();
            System.out.println("Press \'p\' to print; \'a\' to add; \'x\' to exit");
            System.out.println("\'s\' to sort tasks");
            System.out.println("\'f\' to filter by priority - show all IMPORTANT tasks");
            System.out.println("\'r\' to remove dublicate tasks ");
            System.out.println("\'n\' to show all task names");
            System.out.println("\'m\' to check if all task names are longer than 1 symbol");
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
//                    SortedSet<TaskToPerform> taskToPerformSortedSet = new TreeSet<>();
//                    taskToPerformSortedSet.addAll(taskToPerformList);
//                    taskToPerformSortedSet.forEach(System.out::println);
                    taskToPerformList.stream()
                            .sorted()
                            .forEach(System.out::println);
                    break;
                case "x":
                    System.out.println("Pressed 'x'. Exit...");
                    SerializationUtil.serializeObject(taskToPerformList, SerializationUtil.FILENAME);
                    System.out.println("Tasks were saved.");
                    break;
                case "f":
                    System.out.println("Pressed 'f'. All INPORTANT tasks:");
                    taskToPerformList.stream()
                            .filter(task -> task.getPriority().equals(Priority.IMPORTANT))
                            .forEach(System.out::println);
                    break;
                case "m":
                    System.out.println("Pressed 'm'.");
                    boolean areAllNamesLongerThanOneChar = taskToPerformList.stream()
                            .allMatch(task -> task.getName().length() > 1);
                    System.out.println("All task names are longer than one symbol : " + areAllNamesLongerThanOneChar);
                    break;
                case "n":
                    System.out.println("Pressed 'n'.");
                    System.out.println("All task names:");
                    taskToPerformList.stream()
                            .map(task -> task.getName())
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case "r":
                    System.out.println("Pressed 'r'.");
                    System.out.println("All unique tasks:");
                    taskToPerformList = taskToPerformList.stream()
                            .distinct()
                            .collect(Collectors.toList());
                    taskToPerformList.forEach(System.out::println);
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
