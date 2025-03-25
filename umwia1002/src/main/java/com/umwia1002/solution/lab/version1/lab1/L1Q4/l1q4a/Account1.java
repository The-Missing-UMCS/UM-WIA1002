package com.umwia1002.solution.lab.version1.lab1.L1Q4.l1q4a;

import com.umwia1002.solution.lab.version1.lab1.L1Q3.l1q3a.Account;

import java.util.ArrayList;

public class Account1 extends Account {
    private String name;
    private ArrayList<Transaction> transactions;

    Account1(String name, int id, double balance) {
        super(id, balance);
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public boolean withdraw(double amount, String description) {
        boolean isWithdrawSuccessful = super.withdraw(amount);
        if (isWithdrawSuccessful) {
            this.transactions.add(new Transaction(Transaction.WITHDRAW, amount, getBalance(), description));
        }
        return isWithdrawSuccessful;
    }

    public boolean deposit(double amount, String description) {
        boolean isDepositSuccessful = super.deposit(amount);
        if (isDepositSuccessful) {
            this.transactions.add(new Transaction(Transaction.DEPOSIT, amount, getBalance(), description));
        }
        return isDepositSuccessful;
    }

    @Override
    public String toString() {
        String[] content = super.toString().split(System.lineSeparator());
        StringBuilder info = new StringBuilder();
        for (int i = 1; i < content.length; i++) {
            info.append(content[i]).append(System.lineSeparator());
        }

        return """
            Account summary:
            Account holder: %s
            %s""".formatted(getName(), info.toString());
    }


}
