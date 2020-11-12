package by.planner.domain;

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
}
