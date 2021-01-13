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

import java.time.LocalDateTime;

@RunWith(Theories.class)
public class DateUtilTest{

    @DataPoints
    public static String[][] data(){
        return new String[][]{
                {"2021-01-11T10:00:00", "2021-01-11T12:30:00", "0 day(s) 2 hour(s) 30 min 0 sec to deadline."},
                {"2021-01-13T12:00:00", "2021-01-11T14:30:00", "Deadline has already arrived!"}
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
    public void testReturnTwoDateDifference(String[] input) {
        //GIVEN

        //WHEN
        String str = DateUtil.returnTwoDateDifference(LocalDateTime.parse(input[0]), LocalDateTime.parse(input[1]));

        //THEN
        Assert.assertEquals(input[2], str);
//        Assert.assertNotEquals(input[2], str);
    }


}
