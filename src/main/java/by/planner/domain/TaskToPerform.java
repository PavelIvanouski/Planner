package by.planner.domain;

import by.planner.domain.Performable;

public abstract class TaskToPerform implements Performable{

    private String name;
    //private String category;
    private Category category;
    private Priority priority;
    private String dateOfComplition;
    private boolean completed;
    private int timeToComplete;


    public TaskToPerform(String name, Category category, Priority priority,
                         String dateOfComplition, int timeToComplete){
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.dateOfComplition = dateOfComplition;
        this.timeToComplete = timeToComplete;
    }

    public int perform(){
        System.out.println("The task '" + name + "' is performed.");
        if (completed) {
            return 0;
        }
        completed = true;
        return timeToComplete;
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
    //endregion


    @Override
    public String toString(){
        return "Task: name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", date Of comp.='" + dateOfComplition + '\'' +
                ", time to complete=" + timeToComplete + " (min)";
    }
}
