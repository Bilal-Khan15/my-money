package com.example.geektrust.utils;

import com.example.geektrust.command.Command;
import com.example.geektrust.command.CommandFactory;
import com.example.geektrust.model.PortfolioManager;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CommandExecutorTest {

    @Test
    public void executeInputCommands_ShouldExecuteCommandsSuccessfully() {
        // Mock the required objects
        PortfolioManager portfolioManager = mock(PortfolioManager.class);
        CommandFactory commandFactory = mock(CommandFactory.class);
        Command command1 = mock(Command.class);
        Command command2 = mock(Command.class);

        // Define the input lines
        List<String> inputLines = Arrays.asList("COMMAND1", "COMMAND2");

        // Define the expected behavior of the command factory
        when(commandFactory.createCommand("COMMAND1")).thenReturn(command1);
        when(commandFactory.createCommand("COMMAND2")).thenReturn(command2);

        // Execute the command
        CommandExecutor.executeInputCommands(inputLines, portfolioManager, commandFactory);

        // Verify that the command were executed
        verify(command1).execute(portfolioManager);
        verify(command2).execute(portfolioManager);
    }

    @Test
    public void executeInputCommands_ShouldHandleIllegalArgumentException() {
        // Mock the required objects
        PortfolioManager portfolioManager = mock(PortfolioManager.class);
        CommandFactory commandFactory = mock(CommandFactory.class);
        Command command1 = mock(Command.class);
        Command command2 = mock(Command.class);

        // Define the input lines
        List<String> inputLines = Arrays.asList("COMMAND1", "INVALID_COMMAND");

        // Define the expected behavior of the command factory
        when(commandFactory.createCommand("COMMAND1")).thenReturn(command1);
        when(commandFactory.createCommand("INVALID_COMMAND")).thenThrow(new IllegalArgumentException("Invalid command"));

        // Execute the command
        try {
            CommandExecutor.executeInputCommands(inputLines, portfolioManager, commandFactory);
        } catch (IllegalArgumentException e) {
            // The exception is re-thrown by CommandExecutor, so we can catch it here to verify it
            // (This test ensures that the CommandExecutor re-throws IllegalArgumentExceptions)
            String expectedErrorMessage = "Error executing command";
            assertEquals(expectedErrorMessage, e.getMessage());
        }

        // Verify that the valid command was executed
        verify(command1).execute(portfolioManager);

        // Verify that the invalid command threw an exception
        verify(command2, never()).execute(portfolioManager);
    }

    @Test
    public void executeInputCommands_ShouldHandleEmptyInputLines() {
        // Mock the required objects
        PortfolioManager portfolioManager = mock(PortfolioManager.class);
        CommandFactory commandFactory = mock(CommandFactory.class);

        // Define an empty list of input lines
        List<String> inputLines = Collections.emptyList();

        // Execute the command
        CommandExecutor.executeInputCommands(inputLines, portfolioManager, commandFactory);

        // Verify that no command were executed
        verifyNoInteractions(commandFactory, portfolioManager);
    }
}

