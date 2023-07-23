package com.example.geektrust.command;

import com.example.geektrust.model.PortfolioManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class AllocateCommandTest {
    @Mock
    private PortfolioManager portfolioManager;

    private AllocateCommand allocateCommand;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        allocateCommand = new AllocateCommand(5000, 2000, 3000);
    }

    @Test
    public void execute_ShouldInvokeAllocateMoneyMethod_WithCorrectArguments() {
        allocateCommand.execute(portfolioManager);
        verify(portfolioManager).allocateMoney(5000, 2000, 3000);
    }
}
