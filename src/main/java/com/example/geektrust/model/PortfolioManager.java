package com.example.geektrust.model;

import com.example.geektrust.utils.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PortfolioManager {
    private Map<Integer, List<Double>> portfolio;
    private List<Double> sipPayments;
    private List<Double> weights;

    public PortfolioManager() {
        portfolio = new HashMap<>();
        sipPayments = new ArrayList<>();
        weights = new ArrayList<>();
    }

    public void allocateMoney(double equityAmount, double debtAmount, double goldAmount) {
        // Implementation for allocating money to the portfolio
        double totalInvestment = equityAmount + debtAmount + goldAmount;

        weights.add(equityAmount / totalInvestment);
        weights.add(debtAmount / totalInvestment);
        weights.add(goldAmount / totalInvestment);

        List<Double> investment = new ArrayList<>();
        investment.add(equityAmount);
        investment.add(debtAmount);
        investment.add(goldAmount);
        investment.add(totalInvestment);

        portfolio.put(portfolio.size(), investment);
    }

    public void makeSipPayment(double equityAmount, double debtAmount, double goldAmount) {
        // Implementation for making SIP payments
        sipPayments.add(equityAmount);
        sipPayments.add(debtAmount);
        sipPayments.add(goldAmount);
    }

    public void updateGains(double equityGain, double debtGain, double goldGain, String month) {
        // Implementation for updating gains
        if (portfolio.isEmpty()) {
            throw new IllegalStateException("No allocation has been made yet");
        }

        int monthIndex = getMonthIndex(month);
        int portfolioIndex = monthIndex > 0 ? monthIndex - 1 : monthIndex;
        List<Double> previousInvestment = portfolio.get(portfolioIndex);

        List<Double> updatedInvestment = new ArrayList<>();
        double total = 0.0;

        for (int i = 0; i < previousInvestment.size() - 1; i++) {
            double previousValue = previousInvestment.get(i);
            double sipPayment = (monthIndex > 0 && sipPayments.size() > i) ? sipPayments.get(i) : 0.0;
            double gainPercentage = (i == 0) ? equityGain : (i == 1) ? debtGain : goldGain;

            double newValue = calculateNewValue(previousValue, sipPayment, gainPercentage);
            updatedInvestment.add(newValue);
            total += newValue;
        }

        updatedInvestment.add(total);

        portfolio.put(monthIndex, updatedInvestment);
    }

    public void printBalance(String month) {
        // Implementation for printing the portfolio balance for a given month
        if (portfolio.isEmpty()) {
            throw new IllegalStateException("No allocation has been made yet");
        }

        int monthIndex = getMonthIndex(month);

        List<Double> investment = portfolio.get(monthIndex);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < investment.size() - 1; i++) {
            double value = investment.get(i);
            sb.append((int) value).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public void rebalance() {
        // Implementation for rebalancing the portfolio
        if (portfolio.isEmpty()) {
            throw new IllegalStateException("No allocation has been made yet");
        }

        int portfolioSize = portfolio.size();
        if (portfolioSize % 6 != 0) {
            System.out.println("CANNOT_REBALANCE");
            return;
        }

        List<Double> previousInvestment = portfolio.get(portfolioSize - 1);
        int size = previousInvestment.size();
        double total = previousInvestment.get(size - 1);
        List<Double> updatedInvestment = new ArrayList<>();

        for (int i = 0; i < weights.size(); i++) {
            double weight = weights.get(i);

            double newValue = Math.floor(total * weight);
            updatedInvestment.add(newValue);
        }

        updatedInvestment.add(total);
        portfolio.put(portfolioSize - 1, updatedInvestment);

        printBalance(Constants.MONTHS.get(portfolioSize - 1));
    }

    private double calculateNewValue(double previousValue, double sipPayment, double gainPercentage) {
        double valueAfterSip = previousValue + sipPayment;
        double gainAmount = valueAfterSip * (gainPercentage / 100.0);
        return Math.floor(valueAfterSip + gainAmount);
    }

    private static int getMonthIndex(String month) {
        int monthIndex = Constants.MONTHS.indexOf(month.toUpperCase());
        if (monthIndex < 0) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }

        return monthIndex;
    }
}

