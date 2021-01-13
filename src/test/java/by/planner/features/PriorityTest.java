package by.planner.features;

import by.planner.exceptions.TaskCheckedException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PriorityTest{
    @Test
    public void testReturnPriorityPositive() throws TaskCheckedException{
        //GIVEN
        int priorityNum = 1;

        //WHEN
        Priority priority = Priority.returnPriority(priorityNum);

        //THEN
        Assert.assertEquals(Priority.IMPORTANT, priority);
        Assert.assertNotEquals(Priority.OPTIONAL, priority);
    }
}
