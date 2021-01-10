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

import java.time.LocalDateTime;

@RunWith(Theories.class)
public class ReturnUtilTest {
    @Rule
    public ExpectedException expectedExceptionRule = ExpectedException.none();

    @DataPoints
    public static LocalDateTime[][] data() {
        return new LocalDateTime[][]{
                {LocalDateTime.parse("2021-01-11T10:00:00"), LocalDateTime.parse("2021-01-11T12:30:00")},
                {LocalDateTime.parse("2021-03-11T12:00:00"), LocalDateTime.parse("2021-03-11T14:30:00")}
        };
    }

    //    @Test
//    public void testReturnTwoDateDifference() {
//        //GIVEN
//        LocalDateTime firstDate = LocalDateTime.parse("2021-01-11T10:00:00");
//        LocalDateTime secondDate = LocalDateTime.parse("2021-01-11T12:30:00");
//
//        //WHEN
//        String str = ReturnUtil.returnTwoDateDifference(firstDate, secondDate);
//
//        //THEN
//        Assert.assertEquals("0 day(s) 2 hour(s) 30 min 0 sec to deadline.", str);
//        Assert.assertNotEquals("Deadline has already arrived!", str);
//    }
    @Theory
    public void testReturnTwoDateDifference(LocalDateTime[] input) {
        //GIVEN

        //WHEN
        String str = ReturnUtil.returnTwoDateDifference(input[0], input[1]);

        //THEN
        Assert.assertEquals("0 day(s) 2 hour(s) 30 min 0 sec to deadline.", str);
        Assert.assertNotEquals("Deadline has already arrived!", str);
    }

    @Test
    public void testReturnCategory() throws TaskCheckedException {
        //GIVEN
        expectedExceptionRule.expect(TaskCheckedException.class);
        int categoryNum = 0;

        //WHEN
        Category category = ReturnUtil.returnCategory(categoryNum);

        //THEN

    }

    @Test
    public void testreturnPriority() throws TaskCheckedException {
        //GIVEN
        int priorityNum = 1;

        //WHEN
        Priority priority = ReturnUtil.returnPriority(priorityNum);

        //THEN
        Assert.assertEquals(Priority.IMPORTANT,priority);
        Assert.assertNotEquals(Priority.OPTIONAL,priority);
    }
}
