package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SipCommandTest {

    @Test
    public void testExecute() {
        PortfolioManager portfolioManager = Mockito.mock(PortfolioManager.class);
        SipCommand sipCommand = new SipCommand(1000.0, 2000.0, 3000.0);

        sipCommand.execute(portfolioManager);

        // Verify that the makeSipPayment() method of the PortfolioManager is called with the correct amounts
        Mockito.verify(portfolioManager, Mockito.times(1)).makeSipPayment(1000.0, 2000.0, 3000.0);
    }
}
