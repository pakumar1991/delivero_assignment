package com.test;

import com.app.CronParserUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronParserUtilTest {

    @Test
    void TestAllValues(){
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 ", CronParserUtil.getAllValues("month"));
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 " +
                "13 14 15 16 17 18 19 20 21 22 23 ", CronParserUtil.getAllValues("hour"));
        assertEquals("1 2 3 4 5 6 7 8 9 10" +
                " 11 12 13 14 15 16 17 18 19 20 21 22 " +
                "23 24 25 26 27 28 29 30 ", CronParserUtil.getAllValues("day of month"));
        assertEquals("1 2 3 4 5 6 7 ", CronParserUtil.getAllValues("day of week"));
    }

    @Test
    void testRangeOfValues(){
        assertEquals("1 2 3 4 5 ",CronParserUtil.getRangeOfValues("1-5"));
        assertEquals("12 13 14 15 ",CronParserUtil.getRangeOfValues("12-15"));

    }
    @Test
    void testMultipleValues(){
        assertEquals("1 5 ",CronParserUtil.getMultipleValues("1,5"));
    }

    @Test
    void testIncrementalValues(){
        assertEquals("0 15 30 45 ",CronParserUtil.getIncrementalValues("*/15","minute"));
        assertEquals("10 25 40 55 ",CronParserUtil.getIncrementalValues("10/15","minute"));

    }
}
