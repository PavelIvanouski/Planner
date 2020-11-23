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
//        System.out.println("Task 1");
//        System.out.println(Task1);

        TaskToPerform.Builder<Integer> builder2 = new TaskToPerform.Builder<>();
        builder2.withName("To watch a movie");
        builder2.withCategory(Category.CHILLOUT);
        builder2.withPriority(Priority.OPTIONAL);
        builder2.withTaskType(TaskType.ONE_TIME);
        builder2.withDateOfComplition("09/11");
        builder2.withTimeToComplete(120);
        builder2.withId(13133);
        TaskToPerform<Integer> Task2 = builder2.build();
//        System.out.println("Task 2");
//        System.out.println(Task2);

        TaskToPerform.Builder<Integer> builder3 = new TaskToPerform.Builder<>();
        builder3.withName("To sleep");
        builder3.withCategory(Category.CHILLOUT);
        builder3.withPriority(Priority.IMPORTANT);
        builder3.withTaskType(TaskType.ONE_TIME);
        builder3.withDateOfComplition("09/11");
        builder3.withTimeToComplete(120);
        builder3.withId(13133);
        TaskToPerform<Integer> Task3 = builder3.build();
//        System.out.println("Task 3");
//        System.out.println(Task3);

        TaskToPerform.Builder<Integer> builder4 = new TaskToPerform.Builder<>();
        builder4.withName("To sleep");
        builder4.withCategory(Category.CHILLOUT);
        builder4.withPriority(Priority.IMPORTANT);
        builder4.withTaskType(TaskType.ONE_TIME);
        builder4.withDateOfComplition("09/11");
        builder4.withTimeToComplete(10);
        builder4.withId(16);
        TaskToPerform<Integer> Task4 = builder4.build();
//        System.out.println("Task 4");
//        System.out.println(Task4);

        System.out.println("1.-----------");

        List<TaskToPerform> taskToPerformList = new ArrayList<>();
        taskToPerformList.add(Task1);
        taskToPerformList.add(Task2);
        taskToPerformList.add(Task3);
        taskToPerformList.add(Task4);
        taskToPerformList.forEach(System.out::println);
        System.out.println("Press \'p\' to print all tasks");
        System.out.println("Press \'a\' to add a task");
        System.out.println("Press \'s\' to sort tasks");
        Scanner scanner = new Scanner(System.in);
        String pressedKey = scanner.next();
        switch (pressedKey) {
            case "p":
                System.out.println("Pressed 'p':");
                taskToPerformList.forEach(System.out::println);
                break;
            case "a":
                System.out.println("Pressed 'a':");
                TaskToPerform newTask = TaskToPerform.addNewTask(scanner);
                taskToPerformList.add(newTask);
                System.out.println(newTask);
                break;
            case "s":
                System.out.println("Pressed 's':");
                Comparator<TaskToPerform> taskToPerformComparator = new Comparator<TaskToPerform>(){
                    @Override
                    public int compare(TaskToPerform o1, TaskToPerform o2){
                        int result = o1.getName().compareTo(o2.getName());
                        if (result == 0) {
                            result = o1.getTimeToComplete().compareTo(o2.getTimeToComplete());
                        }
                        return result;
                    }
                };
                System.out.println("Sorted:");
                taskToPerformList.sort(taskToPerformComparator);
                taskToPerformList.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid command");
        }


        System.out.println("2.-----------");
        System.out.println("Task 1 hashcode= " + Task1.hashCode());
        System.out.println("Task 2 hashcode= " + Task2.hashCode());
        System.out.println("Task 3 hashcode= " + Task3.hashCode());
        System.out.println("Task1 = Task2 : " + Task1.equals(Task2));
        System.out.println("Task1 = Task3 : " + Task1.equals(Task3));

        System.out.println();
        System.out.println("-------до сортировки--------");
        taskToPerformList.forEach(System.out::println);
        System.out.println("-------после сортировки-----");
        Collections.sort(taskToPerformList);
        taskToPerformList.forEach(System.out::println);

//        System.out.println("New set 'taskToPerforms'");
//        Set<TaskToPerform> taskToPerforms = new HashSet<>();
//        System.out.println("add Task1");
//        taskToPerforms.add(Task1);
//        System.out.println("Set size:" + taskToPerforms.size());
//        System.out.println("add Task2");
//        taskToPerforms.add(Task2);
//        System.out.println("Set size:" + taskToPerforms.size());
//        System.out.println("add Task3");
//        taskToPerforms.add(Task3);
//        System.out.println("Set size:" + taskToPerforms.size());


    }
}
