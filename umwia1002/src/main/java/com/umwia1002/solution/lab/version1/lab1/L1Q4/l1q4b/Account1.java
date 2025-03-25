package com.umwia1002.solution.lab.version1.lab1.L1Q4.l1q4b;

import com.umwia1002.solution.lab.version1.lab1.L1Q3.l1q3b.Account;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public class Account1 extends Account {
    private final String name;
    private final ArrayList<Transaction> transactions;

    Account1(String name, int id, double balance) {
        super(id, balance);
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount, String description) {
        boolean isWithdrawSuccessful = super.withdraw(amount);
        if (isWithdrawSuccessful) {
            this.transactions.add(new Transaction(Transaction.WITHDRAW, amount, getBalance().doubleValue(), description));
        }
        return isWithdrawSuccessful;
    }

    public boolean deposit(double amount, String description) {
        boolean isDepositSuccessful = super.deposit(amount);
        if (isDepositSuccessful) {
            this.transactions.add(new Transaction(Transaction.DEPOSIT, amount, getBalance().doubleValue(), description));
        }
        return isDepositSuccessful;
    }

    @Override
    public String toString() {
        String[] content = super.toString().split(System.lineSeparator());
        String info = Arrays.stream(content, 1, content.length)
            .collect(Collectors.joining(System.lineSeparator()));

        return """
            Account summary:
            Account holder: %s
            %s""".formatted(this.getName(), info);
    }
}
