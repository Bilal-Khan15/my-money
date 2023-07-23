package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ChangeCommandTest {

    @Test
    public void testExecute() {
        // Create a mock PortfolioManager
        PortfolioManager portfolioManager = Mockito.mock(PortfolioManager.class);

        // Create an instance of ChangeCommand with specific gain values and a month
        double equityGain = 1.5;
        double debtGain = 2.0;
        double goldGain = 1.0;
        String month = "JANUARY";
        ChangeCommand changeCommand = new ChangeCommand(equityGain, debtGain, goldGain, month);

        // Call the execute() method
        changeCommand.execute(portfolioManager);

        // Verify that the updateGains() method of PortfolioManager is called with the correct gain values and month
        Mockito.verify(portfolioManager).updateGains(equityGain, debtGain, goldGain, month);
    }
}
