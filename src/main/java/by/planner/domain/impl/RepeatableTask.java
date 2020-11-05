package by.planner.domain.impl;

import by.planner.domain.TaskToPerform;

public class RepeatableTask extends TaskToPerform{

    private int numberOfRepeats;

    public RepeatableTask(String name, String category, String priority, String dateOfComplition,
                          int timeToComplete, int numberOfRepeats){
        super(name, category, priority, dateOfComplition, timeToComplete);
        this.numberOfRepeats = numberOfRepeats;
    }

    @Override
    public int perform(){
        System.out.println("Number of repeats: " + numberOfRepeats);
        return super.perform() * numberOfRepeats;
    }

    @Override
    public String toString(){
        return super.toString() +
                ", number of repeats=" + numberOfRepeats;
    }
}
