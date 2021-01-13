package by.planner.features;

import by.planner.exceptions.TaskCheckedException;

public enum Priority{
    IMPORTANT(1),
    OPTIONAL(2),
    MIDDLE(3);

    private int priorityNum;

    Priority(int priorityNum){
        this.priorityNum = priorityNum;
    }

    public int getPriorityNum(){
        return priorityNum;
    }

    public void setPriorityNum(int priorityNum){
        this.priorityNum = priorityNum;
    }

    public static Priority returnPriority(int priorityNum) throws TaskCheckedException{
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
        if (priorityNewTask == null) {
            throw new TaskCheckedException("Invalid priority");
        }
        return priorityNewTask;
    }
}
