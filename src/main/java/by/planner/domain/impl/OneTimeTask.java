package by.planner.domain.impl;

import by.planner.domain.TaskToPerform;

public class OneTimeTask extends TaskToPerform{
    public OneTimeTask(String name, String category, String priority, String dateOfComplition, int timeToComplete){
        super(name, category, priority, dateOfComplition, timeToComplete);
    }
}
