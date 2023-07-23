package com.example.geektrust.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioManagerTest {

    private PortfolioManager portfolioManager;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        portfolioManager = new PortfolioManager();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testAllocateMoney() {
        portfolioManager.allocateMoney(1000.0, 2000.0, 3000.0);

        Map<Integer, List<Double>> expectedPortfolio = new HashMap<>();
        expectedPortfolio.put(0, Arrays.asList(1000.0, 2000.0, 3000.0, 6000.0));

        Assertions.assertEquals(expectedPortfolio, portfolioManager.getPortfolio());
    }

    @Test
    public void testMakeSipPayment() {
        portfolioManager.makeSipPayment(500.0, 1000.0, 1500.0);

        List<Double> expectedSipPayments = Arrays.asList(500.0, 1000.0, 1500.0);

        Assertions.assertEquals(expectedSipPayments, portfolioManager.getSipPayments());
    }

    @Test
    public void testUpdateGains() {
        portfolioManager.allocateMoney(1000.0, 2000.0, 3000.0);
        portfolioManager.makeSipPayment(500.0, 1000.0, 1500.0);
        portfolioManager.updateGains(2.0, 3.0, 4.0, "FEBRUARY");

        Map<Integer, List<Double>> expectedPortfolio = new HashMap<>();
        expectedPortfolio.put(0, Arrays.asList(1000.0, 2000.0, 3000.0, 6000.0));
        expectedPortfolio.put(1, Arrays.asList(1530.0, 3090.0, 4680.0, 9300.0));

        Assertions.assertEquals(expectedPortfolio, portfolioManager.getPortfolio());
    }

    @Test
    public void testUpdateGains_ThrowsExceptionForEmptyPortfolio() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                portfolioManager.updateGains(2.0, 3.0, 4.0, "JANUARY"));
    }

    @Test
    public void testPrintBalance() {
        portfolioManager.allocateMoney(1000.0, 2000.0, 3000.0);
        portfolioManager.makeSipPayment(500.0, 1000.0, 1500.0);
        portfolioManager.updateGains(2.0, 3.0, 4.0, "JANUARY");

        String expectedOutput = "1020 2060 3120";

        captureOutput(() -> portfolioManager.printBalance("JANUARY"));

        Assertions.assertEquals(expectedOutput, output.toString().trim());
    }

    @Test
    public void testPrintBalance_ThrowsExceptionForEmptyPortfolio() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                portfolioManager.printBalance("JANUARY"));
    }

    @Test
    public void testRebalance() {
        portfolioManager.allocateMoney(1000.0, 2000.0, 3000.0);
        portfolioManager.makeSipPayment(500.0, 1000.0, 1500.0);
        portfolioManager.updateGains(2.0, 3.0, 4.0, "JANUARY");
        portfolioManager.updateGains(6.0, -3.0, 4.0, "FEBRUARY");
        portfolioManager.updateGains(2.0, 3.0, -5.0, "MARCH");
        portfolioManager.updateGains(2.0, 3.0, 4.0, "APRIL");
        portfolioManager.updateGains(-5.0, 6.0, 4.0, "MAY");
        portfolioManager.updateGains(2.0, 3.0, -8.0, "JUNE");
        portfolioManager.rebalance();

        Map<Integer, List<Double>> expectedPortfolio = new HashMap<>();
        expectedPortfolio.put(0, Arrays.asList(1020.0, 2060.0, 3120.0, 6200.0));
        expectedPortfolio.put(1, Arrays.asList(1611.0, 2968.0, 4804.0, 9383.0));
        expectedPortfolio.put(2, Arrays.asList(2153.0, 4087.0, 5988.0, 12228.0));
        expectedPortfolio.put(3, Arrays.asList(2706.0, 5239.0, 7787.0, 15732.0));
        expectedPortfolio.put(4, Arrays.asList(3045.0, 6613.0, 9658.0, 19316.0));
        expectedPortfolio.put(5, Arrays.asList(3620.0, 7240.0, 10860.0, 21721.0));

        Assertions.assertEquals(expectedPortfolio, portfolioManager.getPortfolio());
    }

    @Test
    public void testRebalance_ThrowsExceptionForEmptyPortfolio() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                portfolioManager.rebalance());
    }

    private void captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));
        try {
            action.run();
        } finally {
            System.setOut(originalOut);
        }
    }
}
