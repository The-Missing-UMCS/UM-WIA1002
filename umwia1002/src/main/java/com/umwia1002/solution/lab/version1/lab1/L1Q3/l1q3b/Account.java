package com.umwia1002.solution.lab.version1.lab1.L1Q3.l1q3b;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Getter
public class Account {
    private BigDecimal annualInterestRate = BigDecimal.ZERO; // Use BigDecimal for rates

    private final int id;
    private final LocalDate dateCreated;
    private BigDecimal balance;

    public Account() {
        this(0, 0);
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = BigDecimal.valueOf(balance).setScale(2, RoundingMode.HALF_UP);
        this.dateCreated = LocalDate.now();
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = BigDecimal.valueOf(annualInterestRate)
            .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getMonthlyInterestRate() {
        return this.annualInterestRate.divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP);
    }

    public BigDecimal getMonthlyInterest() {
        return getMonthlyInterestRate().divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_UP)
            .multiply(this.balance).setScale(2, RoundingMode.HALF_UP);
    }

    public boolean withdraw(double amount) {
        BigDecimal withdrawAmount = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
        if (balance.compareTo(withdrawAmount) >= 0) {
            balance = balance.subtract(withdrawAmount);
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance.add(BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return """
            Account Summary:
            Balance: %s
            Monthly Interest: %s
            Date Created: %s""".formatted(balance, getMonthlyInterest(), dateCreated);
    }
}
