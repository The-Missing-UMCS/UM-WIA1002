package com.umwia1002.solution.lab.version1.lab1.L1Q4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class Transaction {
    public static final char WITHDRAW = 'W';
    public static final char DEPOSIT = 'D';

    private final LocalDate date;
    private final char type;
    private final double amount;
    private final double balance;
    private final String description;

    public Transaction(char type, double amount, double balance, String description) {
        this(LocalDate.now(), type, amount, balance, description);
    }

    @Override
    public String toString() {
        return """
            Date: %s
            Type: %s
            Amount: %s
            Balance: %s
            Description: %s
            """.formatted(date, type, amount, balance, description);
    }
}
