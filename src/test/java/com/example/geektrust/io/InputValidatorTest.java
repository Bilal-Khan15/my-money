package com.example.geektrust.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    public void testValidateArguments_WithValidArguments() {
        String[] validArgs = { "input.txt" };
        InputValidator.validateArguments(validArgs); // No exception should be thrown
    }

    @Test
    public void testValidateArguments_WithMissingArguments() {
        String[] invalidArgs = {};
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateArguments(invalidArgs));
    }

    @Test
    public void testValidateArguments_WithNullArguments() {
        assertThrows(NullPointerException.class, () -> InputValidator.validateArguments(null));
    }
}

