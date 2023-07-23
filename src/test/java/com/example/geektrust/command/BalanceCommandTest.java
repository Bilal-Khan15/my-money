package com.example.geektrust.command;

import com.example.mymoney.model.PortfolioManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BalanceCommandTest {

    @Test
    public void testExecute() {
        // Create a mock PortfolioManager
        PortfolioManager portfolioManager = Mockito.mock(PortfolioManager.class);

        // Create an instance of BalanceCommand with a specific month
        String month = "JANUARY";
        BalanceCommand balanceCommand = new BalanceCommand(month);

        // Call the execute() method
        balanceCommand.execute(portfolioManager);

        // Verify that the printBalance() method of PortfolioManager is called with the correct month
        Mockito.verify(portfolioManager).printBalance(month);
    }
}

