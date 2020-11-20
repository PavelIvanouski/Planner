package by.planner.app;

import by.planner.domain.*;

import java.util.*;


public class App{
    public static void main(String[] args){
        System.out.println("1.-------");
        TaskToPerform.Builder<Integer> builder = new TaskToPerform.Builder<>();
        builder.withName("To watch a movie");
        builder.withCategory(Category.CHILLOUT);
        builder.withPriority(Priority.OPTIONAL);
        builder.withTaskType(TaskType.ONE_TIME);
        builder.withDateOfComplition("09/11");
        builder.withTimeToComplete(120);
        builder.withId(13133);
        TaskToPerform<Integer> oneTimeTaskChill = builder.build();
        System.out.println(oneTimeTaskChill);

        TaskToPerform.Builder<String> builder1 = new TaskToPerform.Builder<>();
        TaskToPerform<String> repeatableTask = builder1.withName("To wash the dishes").withCategory(Category.HOMEWORK).
                withPriority(Priority.IMPORTANT).withTaskType(TaskType.REPEATABLE).
                withDateOfComplition("09/11").withTimeToComplete(20).withNumberOfRepeats(3).withId("pfdfdf").build();
        System.out.println(repeatableTask);


        TaskToPerform<String> stringTaskToPerform = new TaskToPerform<>("It-academy homework",
                Category.STUDY, Priority.IMPORTANT, TaskType.ONE_TIME, "12/11",
                60, "@erer");
        System.out.println(stringTaskToPerform);

        System.out.println();

        List<TaskToPerform> taskToPerformList = new ArrayList<>();
        taskToPerformList.add(oneTimeTaskChill);
        taskToPerformList.add(repeatableTask);
        taskToPerformList.add(stringTaskToPerform);

//        System.out.println("Press \'p\' to print all tasks");
//        System.out.println("Press \'a\' to add a task");
//        System.out.println("Press \'s\' to sort tasks");
//        Scanner scanner = new Scanner(System.in);
//        String pressedKey = scanner.next();
//        switch (pressedKey) {
//            case "p":
//                System.out.println("Pressed 'p':");
//                taskToPerformList.forEach(System.out::println);
//                break;
//            case "a":
//                System.out.println("Pressed 'a':");
//                TaskToPerform newTask = TaskToPerform.addNewTask(scanner);
//                taskToPerformList.add(newTask);
//                System.out.println(newTask);
//                break;
//            case "s":
//                System.out.println("Pressed 's':");
//                break;
//            default:
//                System.out.println("Invalid command");
//        }
        System.out.println("2.-------");
        TaskToPerform.Builder<Integer> builder2 = new TaskToPerform.Builder<>();
        builder2.withName("To watch a movie");
        builder2.withCategory(Category.CHILLOUT);
        builder2.withPriority(Priority.OPTIONAL);
        builder2.withTaskType(TaskType.ONE_TIME);
        builder2.withDateOfComplition("09/11");
        builder2.withTimeToComplete(120);
        builder2.withId(13133);
        TaskToPerform<Integer> oneTimeTaskChill1 = builder2.build();
        System.out.println("Task 1");
        System.out.println(oneTimeTaskChill1);

        TaskToPerform.Builder<Integer> builder3 = new TaskToPerform.Builder<>();
        builder3.withName("To watch a movie");
        builder3.withCategory(Category.CHILLOUT);
        builder3.withPriority(Priority.OPTIONAL);
        builder3.withTaskType(TaskType.ONE_TIME);
        builder3.withDateOfComplition("09/11");
        builder3.withTimeToComplete(120);
        builder3.withId(13133);
        TaskToPerform<Integer> oneTimeTaskChill2 = builder3.build();
        System.out.println("Task 2");
        System.out.println(oneTimeTaskChill2);

        TaskToPerform.Builder<Integer> builder4 = new TaskToPerform.Builder<>();
        builder4.withName("To watch a movie");
        builder4.withCategory(Category.CHILLOUT);
        builder4.withPriority(Priority.IMPORTANT);
        builder4.withTaskType(TaskType.ONE_TIME);
        builder4.withDateOfComplition("09/11");
        builder4.withTimeToComplete(120);
        builder4.withId(13133);
        TaskToPerform<Integer> oneTimeTaskChill3 = builder4.build();
        System.out.println("Task 3");
        System.out.println(oneTimeTaskChill3);

        System.out.println("Task 1 hashcode= " + oneTimeTaskChill1.hashCode());
        System.out.println("Task 2 hashcode= " + oneTimeTaskChill2.hashCode());
        System.out.println("Task 3 hashcode= " + oneTimeTaskChill3.hashCode());
        System.out.println("Task1 = Task2 : " + oneTimeTaskChill1.equals(oneTimeTaskChill2));
        System.out.println("Task1 = Task3 : " + oneTimeTaskChill1.equals(oneTimeTaskChill3));

        System.out.println();
        System.out.println("New set 'taskToPerforms'");
        Set<TaskToPerform> taskToPerforms = new HashSet<>();
        System.out.println("add Task1");
        taskToPerforms.add(oneTimeTaskChill1);
        System.out.println("Set size:" + taskToPerforms.size());
        System.out.println("add Task2");
        taskToPerforms.add(oneTimeTaskChill2);
        System.out.println("Set size:" + taskToPerforms.size());
        System.out.println("add Task3");
        taskToPerforms.add(oneTimeTaskChill3);
        System.out.println("Set size:" + taskToPerforms.size());


    }
}
