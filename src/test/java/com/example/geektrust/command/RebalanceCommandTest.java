package com.example.geektrust.command;

import com.example.mymoney.model.PortfolioManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RebalanceCommandTest {

    @Test
    public void testExecute() {
        PortfolioManager portfolioManager = Mockito.mock(PortfolioManager.class);
        RebalanceCommand rebalanceCommand = new RebalanceCommand();

        rebalanceCommand.execute(portfolioManager);

        // Verify that the rebalance() method of the PortfolioManager is called
        Mockito.verify(portfolioManager, Mockito.times(1)).rebalance();
    }
}
