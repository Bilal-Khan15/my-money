package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AllocateCommand implements Command {
    private final double equityAllocation;
    private final double debtAllocation;
    private final double goldAllocation;

    @Override
    public void execute(PortfolioManager portfolioManager) {
        portfolioManager.allocateMoney(equityAllocation, debtAllocation, goldAllocation);
    }
}
