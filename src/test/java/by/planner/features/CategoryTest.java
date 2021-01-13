package by.planner.features;

import by.planner.exceptions.TaskCheckedException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CategoryTest{
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
        Category category = Category.returnCategory(input);

        //THEN
        Assert.assertEquals(Category.CHILLOUT, category);
    }

    @Test
    public void testReturnCategoryNegative() throws TaskCheckedException{
        //GIVEN
        expectedExceptionRule.expect(TaskCheckedException.class);
        int categoryNum = 0;

        //WHEN
        Category category = Category.returnCategory(categoryNum);

        //THEN

    }


}
