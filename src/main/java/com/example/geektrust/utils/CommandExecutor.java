package com.example.geektrust.utils;

import com.example.geektrust.command.Command;
import com.example.geektrust.command.CommandFactory;
import com.example.geektrust.model.PortfolioManager;

import java.util.List;

public class CommandExecutor {
    public static void executeInputCommands(List<String> inputLines, PortfolioManager portfolioManager, CommandFactory commandFactory) {
        for (String line : inputLines) {
            try {
                Command command = commandFactory.createCommand(line);
                command.execute(portfolioManager);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error executing command");
            }
        }
    }
}