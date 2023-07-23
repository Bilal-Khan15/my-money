package com.example.geektrust.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ConstantsTest {

    @Test
    public void testMonthsList() {
        List<String> expectedMonths = Arrays.asList(
                "JANUARY", "FEBRUARY", "MARCH", "APRIL",
                "MAY", "JUNE", "JULY", "AUGUST",
                "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
        );

        Assertions.assertEquals(expectedMonths, Constants.MONTHS);
    }
}
