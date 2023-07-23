package com.example.geektrust.command;

import com.example.geektrust.exception.CommandNotFoundException;
import com.example.geektrust.utils.CommandType;

public class CommandFactory {
    public Command createCommand(String inputLine) {
        String[] instructions = inputLine.trim().split(" ");

        if (instructions.length < 1) {
            throw new CommandNotFoundException("Invalid command format");
        }

        String commandTypeString = instructions[0];
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandTypeString);
        } catch (IllegalArgumentException e) {
            throw new CommandNotFoundException("Unknown command: " + commandTypeString);
        }

        switch (commandType) {
            case ALLOCATE:
                return createAllocateCommand(instructions);
            case SIP:
                return createSipCommand(instructions);
            case CHANGE:
                return createChangeCommand(instructions);
            case BALANCE:
                return createBalanceCommand(instructions);
            case REBALANCE:
                return createRebalanceCommand(instructions);
            default:
                throw new CommandNotFoundException("Unknown command: " + commandTypeString);
        }
    }

    private Command createAllocateCommand(String[] instructions) {
        validateInstructionsLength(instructions, 4, "Invalid ALLOCATE command format");

        double equityAmount = parseDouble(instructions[1]);
        double debtAmount = parseDouble(instructions[2]);
        double goldAmount = parseDouble(instructions[3]);

        return new AllocateCommand(equityAmount, debtAmount, goldAmount);
    }

    private Command createSipCommand(String[] instructions) {
        validateInstructionsLength(instructions, 4, "Invalid SIP command format");

        double equityAmount = parseDouble(instructions[1]);
        double debtAmount = parseDouble(instructions[2]);
        double goldAmount = parseDouble(instructions[3]);

        return new SipCommand(equityAmount, debtAmount, goldAmount);
    }

    private Command createChangeCommand(String[] instructions) {
        validateInstructionsLength(instructions, 5, "Invalid CHANGE command format");

        double equityGain = parsePercentage(instructions[1]);
        double debtGain = parsePercentage(instructions[2]);
        double goldGain = parsePercentage(instructions[3]);
        String month = instructions[4];

        return new ChangeCommand(equityGain, debtGain, goldGain, month);
    }

    private Command createBalanceCommand(String[] instructions) {
        validateInstructionsLength(instructions, 2, "Invalid BALANCE command format");

        String month = instructions[1];

        return new BalanceCommand(month);
    }

    private Command createRebalanceCommand(String[] instructions) {
        validateInstructionsLength(instructions, 1, "Invalid REBALANCE command format");

        return new RebalanceCommand();
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric value: " + value);
        }
    }

    private double parsePercentage(String value) {
        try {
            // Remove the '%' symbol before parsing
            String numericValue = value.replace("%", "");
            return Double.parseDouble(numericValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid percentage value: " + value);
        }
    }

    private void validateInstructionsLength(String[] instructions, int expectedLength, String errorMessage) {
        if (instructions.length != expectedLength) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
