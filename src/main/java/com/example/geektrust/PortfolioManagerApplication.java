package com.example.geektrust;

import com.example.geektrust.command.CommandFactory;
import com.example.geektrust.utils.CommandExecutor;
import com.example.geektrust.io.InputReader;
import com.example.geektrust.model.PortfolioManager;

import java.util.List;

import com.example.geektrust.io.InputValidator;

public class PortfolioManagerApplication {
    public static void main(String[] commandLineArguments) {
        InputValidator.validateArguments(commandLineArguments);

        String inputFilePath = commandLineArguments[0];
        List<String> inputLines = InputReader.readInputFile(inputFilePath);

        PortfolioManager portfolioManager = new PortfolioManager();
        CommandFactory commandFactory = new CommandFactory();

        CommandExecutor.executeInputCommands(inputLines, portfolioManager, commandFactory);
    }
}
