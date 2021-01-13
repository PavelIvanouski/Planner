package by.planner.util;

import by.planner.exceptions.TaskCheckedException;
import by.planner.features.Category;
import by.planner.features.Priority;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(Theories.class)
public class EnumUtilTest{

    @Rule
    public ExpectedException expectedExceptionRule = ExpectedException.none();

    @DataPoints
    public static Integer[] data(){
        return new Integer[]{1, 2};
    }

    @Theory
    public void testReturnCategory(Integer input) throws TaskCheckedException{
        //GIVEN

        //WHEN
        Category category = EnumUtil.returnCategory(input);

        //THEN
        Assert.assertEquals(Category.CHILLOUT, category);
    }

    @Test
    public void testReturnCategoryNegative() throws TaskCheckedException{
        //GIVEN
        expectedExceptionRule.expect(TaskCheckedException.class);
        int categoryNum = 0;

        //WHEN
        Category category = EnumUtil.returnCategory(categoryNum);

        //THEN

    }


    @Test
    public void testreturnPriorityPositive() throws TaskCheckedException{
        //GIVEN
        int priorityNum = 1;

        //WHEN
        Priority priority = EnumUtil.returnPriority(priorityNum);

        //THEN
        Assert.assertEquals(Priority.IMPORTANT, priority);
        Assert.assertNotEquals(Priority.OPTIONAL, priority);
    }
}
