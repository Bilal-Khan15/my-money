package com.example.geektrust.utils;

import org.junit.jupiter.api.Test;

public class CommandTypeTest {

    @Test
    public void testEnumValues() {
        // Ensure that the enum values are correctly defined
        assertEquals(CommandType.ALLOCATE, CommandType.valueOf("ALLOCATE"));
        assertEquals(CommandType.SIP, CommandType.valueOf("SIP"));
        assertEquals(CommandType.CHANGE, CommandType.valueOf("CHANGE"));
        assertEquals(CommandType.BALANCE, CommandType.valueOf("BALANCE"));
        assertEquals(CommandType.REBALANCE, CommandType.valueOf("REBALANCE"));
    }

    @Test
    public void testEnumToString() {
        // Ensure that the enum's toString() method returns the expected string representation
        assertEquals("ALLOCATE", CommandType.ALLOCATE.toString());
        assertEquals("SIP", CommandType.SIP.toString());
        assertEquals("CHANGE", CommandType.CHANGE.toString());
        assertEquals("BALANCE", CommandType.BALANCE.toString());
        assertEquals("REBALANCE", CommandType.REBALANCE.toString());
    }
}
