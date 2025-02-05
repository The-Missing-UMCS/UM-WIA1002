package com.umwia1002.solution.lab.version2.lab6.Q1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern PATTERN = Pattern.compile("([DW])\\s(\\d+)");

    public static void main(String[] args) {
        // 1. Read the transactions to the queue and print the transaction
        Queue<String> transactions = new ArrayDeque<>();
        String transaction = "D 400 | W 300 | W 700 | D 200 | D 450 | W 120";
        System.out.println("Enter transactions : " + transaction);
        readTransaction(transactions, transaction);
        printTransaction(transactions);

        // 2. Process the transaction based on the type (D - Deposit, W - Withdraw)
        int initialBalance = 500;
        processTransaction(transactions, initialBalance);
    }

    private static void processTransaction(Queue<String> transactions, int initialBalance) {
        System.out.println("Initial Balance : " + initialBalance);
        while (!transactions.isEmpty()) {
            String currentRecord = transactions.poll();
            int value = Integer.parseInt(currentRecord.substring(2));
            String format = "%s %-10s %-5d %-13s New Balance= %d%n";

            if (currentRecord.charAt(0) == 'D') {
                System.out.printf(format, "+".repeat(3), "Deposit", value,
                    "", initialBalance += value);
            } else {
                boolean isValid = initialBalance >= value;
                System.out.printf(format, "-".repeat(3), "Withdraw", value,
                    isValid ? "" : "[Rejected]", initialBalance -= isValid ? value : 0);
            }
        }
    }

    private static void readTransaction(Queue<String> transactions, String transaction) {
        Matcher matcher = PATTERN.matcher(transaction);
        while (matcher.find()) {
            transactions.add(matcher.group());
        }
    }

    private static void printTransaction(Queue<String> transactions) {
        for (String transaction : transactions) {
            System.out.print(transaction + "  -->  ");
        }
        System.out.println();
    }
}
