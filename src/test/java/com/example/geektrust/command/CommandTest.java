package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CommandTest {

    @Test
    public void testExecute() {
        // Create a mock PortfolioManager
        PortfolioManager portfolioManager = Mockito.mock(PortfolioManager.class);

        // Create an instance of a concrete class implementing the Command interface
        Command command = new Command() {
            @Override
            public void execute(PortfolioManager portfolioManager) {
                portfolioManager.rebalance();
            }
        };

        // Call the execute() method
        command.execute(portfolioManager);

        // Verify that the rebalance() method of PortfolioManager is called
        Mockito.verify(portfolioManager).rebalance();
    }
}
