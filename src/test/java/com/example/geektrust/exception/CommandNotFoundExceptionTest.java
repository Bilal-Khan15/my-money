package com.example.geektrust.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandNotFoundExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Command not found";
        CommandNotFoundException exception = new CommandNotFoundException(errorMessage);

        // Verify that the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithNullMessage() {
        CommandNotFoundException exception = new CommandNotFoundException(null);

        // Verify that the exception message is set to null
        assertEquals(null, exception.getMessage());
    }
}

