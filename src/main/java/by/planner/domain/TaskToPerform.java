package by.planner.domain;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TaskToPerform<T> implements Performable, Comparable<TaskToPerform> {

    private String name;
    private Category category;
    private Priority priority;
    private TaskType taskType;
    private String dateOfComplition;
    private boolean completed;
    private Integer timeToComplete;
    private Integer numberOfRepeats;
    private T id;

    public static class Builder<T>{

        private String name;
        private Category category;
        private Priority priority;
        private TaskType taskType;
        private String dateOfComplition;
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

        public Builder withDateOfComplition(String dateOfComplition){
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
                         String dateOfComplition, int timeToComplete, T id){
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

    public String getDateOfComplition(){
        return dateOfComplition;
    }

    public void setDateOfComplition(String dateOfComplition){
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

    @Override
    public int hashCode(){
        return Objects.hash(name, category, priority, taskType, dateOfComplition,
                timeToComplete, numberOfRepeats, id);
    }

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
                ", date Of comp.='" + dateOfComplition + '\'' +
                ", time to complete=" + timeToComplete + " (min)" + '\'' +
                ", id=" + id;
    }

    public static void addNewTask (Scanner scanner, List list) throws TaskCheckedExeption{
        System.out.println("Enter task name:");
        String taskName = scanner.nextLine();
        System.out.println("Enter category");
        System.out.println("1 - CHILLOUT, 2 - HOMEWORK, 3 - STUDY, 4 - WORK :");
        int categoryNum = scanner.nextInt();
        System.out.println("Enter priority");
        System.out.println("1 - IMPORTANT, 2 - OPTIONAL, 3 - MIDDLE:");
        int priorityNum = scanner.nextInt();
        System.out.println("Enter task type");
        System.out.println("1 - ONE_TIME, 2 - REPEATABLE:");
        int typeNum = scanner.nextInt();

        System.out.println("Enter time to complete:");
        int timeToComplete = scanner.nextInt();
        System.out.println("Enter Integer id:");
        int idInteger = scanner.nextInt();

        TaskToPerform.Builder<Integer> builder = new TaskToPerform.Builder<>();
        builder.withName(taskName);
        Category categoryNewTask;
        switch (categoryNum) {
            case 1:
                categoryNewTask = Category.CHILLOUT;
                break;
            case 2:
                categoryNewTask = Category.HOMEWORK;
                break;
            case 3:
                categoryNewTask = Category.STUDY;
                break;
            case 4:
                categoryNewTask = Category.WORK;
                break;
            default:
                categoryNewTask = null;
                break;
        }
        if (categoryNum > 4) {
            throw new TaskCheckedExeption("Task " + taskName + " has no category!");
        }
        builder.withCategory(categoryNewTask);
        Priority priorityNewTask;
        switch (priorityNum) {
            case 1:
                priorityNewTask = Priority.IMPORTANT;
                break;
            case 2:
                priorityNewTask = Priority.OPTIONAL;
                break;
            case 3:
                priorityNewTask = Priority.MIDDLE;
                break;
            default:
                priorityNewTask = null;
                break;
        }
        builder.withPriority(priorityNewTask);
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
        builder.withDateOfComplition("24/11");
        builder.withTimeToComplete(timeToComplete);
        builder.withId(idInteger);
        TaskToPerform<Integer> newTask = builder.build();
        list.add(newTask);
        System.out.println(newTask + " added.");
        scanner.nextLine();
    }

}
