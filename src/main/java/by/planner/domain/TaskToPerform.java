package by.planner.domain;

import java.util.Objects;
import java.util.Scanner;

public class TaskToPerform<T> implements Performable{

    private String name;
    private Category category;
    private Priority priority;
    private TaskType taskType;
    private String dateOfComplition;
    private boolean completed;
    private int timeToComplete;
    private int numberOfRepeats;
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


    /*public TaskToPerform (String name){
        this.name = name;
    }*/

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

    public String getDateOfComplition(){
        return dateOfComplition;
    }

    public void setDateOfComplition(String dateOfComplition){
        this.dateOfComplition = dateOfComplition;
    }

    public int getTimeToComplete(){
        return timeToComplete;
    }

    public void setTimeToComplete(int timeToComplete){
        this.timeToComplete = timeToComplete;
    }

    public T getId(){
        return id;
    }

    public void setId(T id){
        this.id = id;
    }

    //endregion

//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TaskToPerform<?> that = (TaskToPerform<?>) o;
//        return timeToComplete == that.timeToComplete &&
//                numberOfRepeats == that.numberOfRepeats &&
//                Objects.equals(name, that.name) &&
//                category == that.category &&
//                priority == that.priority &&
//                taskType == that.taskType &&
//                Objects.equals(dateOfComplition, that.dateOfComplition) &&
//                Objects.equals(id, that.id);
//    }

//    @Override
//    public int hashCode(){
//        return Objects.hash(name, category, priority, taskType,
//                dateOfComplition, timeToComplete, numberOfRepeats, id);
//    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskToPerform<?> that = (TaskToPerform<?>) o;
        return timeToComplete == that.timeToComplete &&
                numberOfRepeats == that.numberOfRepeats &&
//                name.equals(that.name) &&
                (name == that.name || (name != null && name.equals(that.name))) &&
                category == that.category &&
                priority == that.priority &&
                taskType == that.taskType &&
//                dateOfComplition.equals(that.dateOfComplition) &&
                (dateOfComplition == that.dateOfComplition ||
                        (dateOfComplition != null && dateOfComplition.equals(that.dateOfComplition))) &&
                id.equals(that.id);
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 37 * result + (name == null ? 0 : name.hashCode());
        result = 37 * result + (category == null ? 0 : category.hashCode());
        result = 37 * result + (priority == null ? 0 : priority.hashCode());
        result = 37 * result + (taskType == null ? 0 : taskType.hashCode());
        result = 37 * result + (dateOfComplition == null ? 0 : dateOfComplition.hashCode());
        result = 37 * result + timeToComplete;
        result = 37 * result + numberOfRepeats;
//        if (id instanceof Integer) {
//            result = 37 * result + (int) id;
//        } else if (id instanceof String) {
//            result = 37 * result + id.hashCode();
//        }
        result = 37 * result + id.hashCode();
        return result;
    }

//

    @Override
    public String toString(){
        return "Task: name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", task type='" + taskType + '\'' +
                (taskType.equals(TaskType.REPEATABLE) ? (", number of repeats=" +
                        (numberOfRepeats == 0 ? 1 : numberOfRepeats)) : "") +
                ", date Of comp.='" + dateOfComplition + '\'' +
                ", time to complete=" + timeToComplete + " (min)" +
                ", id=" + id;
    }


    public static TaskToPerform addNewTask(Scanner scanner){
        System.out.println("Enter task name:");
        String taskName = scanner.next();
        System.out.println("Enter category");
        System.out.println("1 - CHILLOUT, 2 - HOMEWORK, 3 - STUDY, 4 - WORK :");
        int categoryNum = scanner.nextInt();
        System.out.println("Enter priority");
        System.out.println("1 - IMPORTANT, 2 - OPTIONAL, 3 - MIDDLE:");
        int priorityNum = scanner.nextInt();
        System.out.println("Enter task type");
        System.out.println("1 - ONE_TIME, 2 - REPEATABLE:");
        int typeNum = scanner.nextInt();
        System.out.println("Enter String id:");
        String idStr = scanner.next();

        TaskToPerform.Builder<String> builder = new TaskToPerform.Builder<>();
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
        }
        builder.withPriority(priorityNewTask);
        TaskType taskTypeNewTask;
        switch (typeNum) {
            case 1:
                taskTypeNewTask = TaskType.ONE_TIME;
                break;
            case 2:
                taskTypeNewTask = TaskType.REPEATABLE;
                break;
            default:
                taskTypeNewTask = null;
        }
        builder.withTaskType(taskTypeNewTask);
//        builder.withDateOfComplition("09/11");
//        builder.withTimeToComplete(120);
        builder.withId(idStr);
        TaskToPerform<Integer> newTask = builder.build();
        return newTask;
    }

}
