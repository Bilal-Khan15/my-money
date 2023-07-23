package com.example.geektrust;

import com.example.geektrust.command.CommandFactory;
import com.example.geektrust.model.PortfolioManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PortfolioManagerApplicationTest {

    private PortfolioManager portfolioManager;
    private CommandFactory commandFactory;

    @BeforeEach
    public void setUp() {
        portfolioManager = mock(PortfolioManager.class);
        commandFactory = mock(CommandFactory.class);
    }

    @Test
    public void testMain_WithMissingArguments() {
        String[] invalidArgs = {};

        // Test that validateArguments throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> PortfolioManagerApplication.main(invalidArgs));
    }
}

