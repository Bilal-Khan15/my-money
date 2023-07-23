package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BalanceCommand implements Command {
    private final String targetMonth;

    @Override
    public void execute(PortfolioManager portfolioManager) {
        portfolioManager.printBalance(targetMonth);
    }
}
