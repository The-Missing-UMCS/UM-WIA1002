package com.umwia1002.solution.tutorial.tutorial03.t3q1.impl;

import lombok.Getter;
import lombok.Setter;

public class CashRegister {

    @Setter
    private double balance;

    @Getter
    private double totalGain;

    public CashRegister(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized double acceptAndReturn(double payment, double idealChange) {
        totalGain += payment;
        double change = Math.min(idealChange, balance);
        balance -= change;
        return change;
    }

    public synchronized void addBalance(double amount) {
        balance += amount;
    }
}

