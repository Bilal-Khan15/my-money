package com.example.geektrust.command;

import com.example.mymoney.model.PortfolioManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeCommand implements Command {
    private final double equityPercentageGain;
    private final double debtPercentageGain;
    private final double goldPercentageGain;
    private final String targetMonth;

    @Override
    public void execute(PortfolioManager portfolioManager) {
        portfolioManager.updateGains(equityPercentageGain, debtPercentageGain, goldPercentageGain, targetMonth);
    }
}
