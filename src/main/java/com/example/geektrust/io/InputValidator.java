package com.example.geektrust.io;

public class InputValidator {
    private static final int MIN_ARGUMENTS_LENGTH = 1;

    public static void validateArguments(String[] commandLineArguments) {
        if (commandLineArguments.length < MIN_ARGUMENTS_LENGTH) {
            throw new IllegalArgumentException("Input file path is missing");
        }
    }
}

