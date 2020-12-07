package by.planner.domain;

import by.planner.domain.exceptions.TaskCheckedException;
import by.planner.domain.exceptions.TaskUncheckedException;
import by.planner.domain.features.Category;
import by.planner.domain.features.Priority;
import by.planner.domain.features.ReturnFeature;
import by.planner.domain.features.TaskType;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TaskToPerform<T> implements Performable, Comparable<TaskToPerform>{

    private String name;
    private Category category;
    private Priority priority;
    private TaskType taskType;
    private LocalDateTime dateOfComplition;
    private boolean completed;
    private Integer timeToComplete;
    private Integer numberOfRepeats;
    private T id;

    public static class Builder<T>{

        private String name;
        private Category category;
        private Priority priority;
        private TaskType taskType;
        private LocalDateTime dateOfComplition;
        private boolean completed;
        private int timeToComplete;
        private int numberOfRepeats;
        private T id;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withCategory(Category category){
            this.category = category;
            return this;
        }

        public Builder withPriority(Priority priority){
            this.priority = priority;
            return this;
        }

        public Builder withTaskType(TaskType taskType){
            this.taskType = taskType;
            return this;
        }

        public Builder withDateOfComplition(LocalDateTime dateOfComplition){
            this.dateOfComplition = dateOfComplition;
            return this;
        }

        public Builder withTimeToComplete(int timeToComplete){
            this.timeToComplete = timeToComplete;
            return this;
        }

        public Builder withNumberOfRepeats(int numberOfRepeats){
            this.numberOfRepeats = numberOfRepeats;
            return this;
        }

        public Builder withId(T id){
            this.id = id;
            return this;
        }

        public TaskToPerform build(){
            TaskToPerform taskToPerform = new TaskToPerform();
            taskToPerform.name = this.name;
            taskToPerform.category = this.category;
            taskToPerform.priority = this.priority;
            taskToPerform.taskType = this.taskType;
            taskToPerform.dateOfComplition = this.dateOfComplition;
            taskToPerform.timeToComplete = this.timeToComplete;
            taskToPerform.numberOfRepeats = this.numberOfRepeats;
            taskToPerform.id = this.id;
            return taskToPerform;
        }
    }

    public TaskToPerform(){

    }

    public TaskToPerform(String name, Category category, Priority priority, TaskType taskType,
                         LocalDateTime dateOfComplition, int timeToComplete, T id){
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.taskType = taskType;
        this.dateOfComplition = dateOfComplition;
        this.timeToComplete = timeToComplete;
        this.id = id;
    }

    public int perform(){
        System.out.println("The task '" + name + "' is performed.");
        if (completed) {
            return 0;
        }
        completed = true;
        int timeToCompleteTask = 0;
        if (taskType.equals(TaskType.REPEATABLE)) {
            timeToCompleteTask = timeToComplete * (numberOfRepeats == 0 ? 1 : numberOfRepeats);
        } else {
            timeToCompleteTask = timeToComplete;
        }
        return timeToCompleteTask;
    }

    public void cancel(){
        System.out.println("The task '" + name + "' is canceled.");
    }

    //region getters/setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Priority getPriority(){
        return priority;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }

    public TaskType getTaskType(){
        return taskType;
    }

    public void setTaskType(TaskType taskType){
        this.taskType = taskType;
    }

    public LocalDateTime getDateOfComplition(){
        return dateOfComplition;
    }

    public void setDateOfComplition(LocalDateTime dateOfComplition){
        this.dateOfComplition = dateOfComplition;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public Integer getTimeToComplete(){
        return timeToComplete;
    }

    public void setTimeToComplete(Integer timeToComplete){
        this.timeToComplete = timeToComplete;
    }

    public Integer getNumberOfRepeats(){
        return numberOfRepeats;
    }

    public void setNumberOfRepeats(Integer numberOfRepeats){
        this.numberOfRepeats = numberOfRepeats;
    }

    public T getId(){
        return id;
    }

    public void setId(T id){
        this.id = id;
    }
    //endregion

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskToPerform<?> that = (TaskToPerform<?>) o;
        return (numberOfRepeats == that.numberOfRepeats)
                && (name.equals(that.name))
                && (category == that.category)
                && (priority == that.priority)
                && (taskType == that.taskType)
                && (dateOfComplition.equals(that.dateOfComplition))
                && (timeToComplete.equals(that.timeToComplete))
                && (id.equals(that.id));
    }

//    @Override
//    public boolean equals(Object o){
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        TaskToPerform<?> that = (TaskToPerform<?>) o;
//        return (name.equals(that.name));
//    }

    @Override
    public int hashCode(){
        return Objects.hash(name, category, priority, taskType, dateOfComplition,
                timeToComplete, numberOfRepeats, id);
    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(name);
//    }

    @Override
    public int compareTo(TaskToPerform o){
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.timeToComplete.compareTo(o.timeToComplete);
        }
        return result;
    }

    @Override
    public String toString(){
        return "Task: name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", task type='" + taskType + '\'' +
                (taskType.equals(TaskType.REPEATABLE) ? (", number of repeats=" +
                        (numberOfRepeats == 0 ? 1 : numberOfRepeats)) : "") +
                ", date Of comp.='" +
                (DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(dateOfComplition)) + '\'' +
                ", time to complete=" + timeToComplete + " (min)" + '\'' +
                ", id=" + id;
    }

    public static void addNewTask(Scanner scanner, List list, LocalDateTime currentDate) throws TaskUncheckedException{
        TaskToPerform.Builder<Integer> builder = new TaskToPerform.Builder<>();

        System.out.println("Enter task name:");
        String taskName = scanner.nextLine();
        builder.withName(taskName);

        System.out.println("Enter category");
        System.out.println("1 - CHILLOUT, 2 - HOMEWORK, 3 - STUDY, 4 - WORK :");
        int categoryNum = scanner.nextInt();

        Category categoryNewTask;
        categoryNewTask = null;
        try {
            categoryNewTask = ReturnFeature.returnCategory(categoryNum);
        } catch (TaskCheckedException e) {
            e.printStackTrace();
            categoryNewTask = Category.CHILLOUT;
        } finally {
            builder.withCategory(categoryNewTask);
        }

        System.out.println("Enter priority");
        System.out.println("1 - IMPORTANT, 2 - OPTIONAL, 3 - MIDDLE:");
        int priorityNum = scanner.nextInt();
        Priority priorityNewTask;
        try {
            priorityNewTask = ReturnFeature.returnPriority(priorityNum);
        } catch (Exception e) {
            e.printStackTrace();
            priorityNewTask = Priority.MIDDLE;
        }
        builder.withPriority(priorityNewTask);


        System.out.println("Enter task type");
        System.out.println("1 - ONE_TIME, 2 - REPEATABLE:");
        int typeNum = scanner.nextInt();
        if (typeNum < 1 || typeNum > 2) {
            typeNum = 1;
        }
        if (typeNum != 1 && typeNum != 2) {
            throw new TaskUncheckedException();
        }
        TaskType taskTypeNewTask;
        switch (typeNum) {
            case 1:
                taskTypeNewTask = TaskType.ONE_TIME;
                break;
            case 2:
                taskTypeNewTask = TaskType.REPEATABLE;
                System.out.println("Enter number of repeats:");
                int numberOfRepeats = scanner.nextInt();
                builder.withNumberOfRepeats(numberOfRepeats);
                break;
            default:
                taskTypeNewTask = null;
                break;
        }
        builder.withTaskType(taskTypeNewTask);

        int timeToComplete = 0;
        do {
            System.out.println("Enter time to complete (positive number):");
            try {
                timeToComplete = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Try again.");
                scanner.next();
            }
        } while (timeToComplete <= 0);
        builder.withTimeToComplete(timeToComplete);

        int idInteger = 0;
        do {
            System.out.println("Enter Integer id:");
            try {
                idInteger = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Try again.");
                scanner.next();
            }
        } while (idInteger <= 0);
        builder.withId(idInteger);
        LocalDateTime taskDate = ReturnFeature.enterTaskDate(scanner, currentDate);
        builder.withDateOfComplition(taskDate);

        TaskToPerform<Integer> newTask = builder.build();

        list.add(newTask);
        System.out.println(newTask + " added.");
        scanner.nextLine();
    }


}
