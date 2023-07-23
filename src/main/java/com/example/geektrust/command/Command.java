package com.example.geektrust.command;

import com.example.mymoney.model.PortfolioManager;

public interface Command {
    void execute(PortfolioManager portfolioManager);
}
