package com.example.geektrust.command;

import com.example.mymoney.model.PortfolioManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SipCommand implements Command {
    private final double equityPayment;
    private final double debtPayment;
    private final double goldPayment;

    @Override
    public void execute(PortfolioManager portfolioManager) {
        portfolioManager.makeSipPayment(equityPayment, debtPayment, goldPayment);
    }
}
