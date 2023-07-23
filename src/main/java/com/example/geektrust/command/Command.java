package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;

public interface Command {
    void execute(PortfolioManager portfolioManager);
}
