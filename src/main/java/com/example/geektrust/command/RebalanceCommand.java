package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RebalanceCommand implements Command {
    @Override
    public void execute(PortfolioManager portfolioManager) {
        portfolioManager.rebalance();
    }
}
