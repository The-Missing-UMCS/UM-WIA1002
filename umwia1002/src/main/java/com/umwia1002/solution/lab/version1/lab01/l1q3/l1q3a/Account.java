package com.umwia1002.solution.lab.version1.lab01.l1q3.l1q3a;

import java.util.Date;


public class Account {

    private int id;
    private Date dateCreated;
    private double balance;
    private double annualInterestRate = 0;

    public Account() {
        this(0, 0);
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
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
