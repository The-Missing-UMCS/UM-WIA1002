package com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3a;

import com.umwia1002.solution.lab.version1.lab06.l6q5.advanced.util.Util;
import com.umwia1002.solution.util.InputUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.umwia1002.solution.util.ConsoleUtil.*;

public class Main {

    private static final Pattern QUERY_PATTERN = Pattern.compile(
        "(Buy|Sell) (\\d+) shares at \\$(\\d+) each");

    public static void main(String[] args) {
        int totalCapitalGain = 0;

        Deque<ShareTransaction> transactions = new LinkedList<>();

        while (true) {
            String query = InputUtil.getStringInput(
                "Enter your query (In format 'Buy / Sell x shares at $y each'): ");

            if (query.isEmpty()) {
                break;
            }

            if (!isValidQuery(query)) {
                logError("Invalid query: %s".formatted(query));
                continue;
            }

            String[] info = query.split("\\s");
            String action = info[0];
            int shares = Integer.parseInt(info[1]);
            int price = Integer.parseInt(info[4].substring(1));

            totalCapitalGain = switch (action) {
                case "Buy" -> {
                    buy(transactions, shares, price);
                    yield totalCapitalGain;
                }
                case "Sell" -> sell(transactions, shares, price, totalCapitalGain);
                default -> totalCapitalGain;
            };
        }

        logGreen("Final Capital Gain / Loss: %s".formatted(totalCapitalGain));
    }

    public static boolean isValidQuery(String query) {
        return QUERY_PATTERN.matcher(query).matches();
    }

    public static void buy(Deque<ShareTransaction> transactions, int shares, int price) {
        System.out.println("Buying now...");
        Util.delay(500);
        transactions.addLast(new ShareTransaction(shares, price));
        printTransactions(transactions);
    }

    public static int sell(Deque<ShareTransaction> transactions,
                           int shares,
                           int price,
                           int totalCapitalGain) {
        logInfo("Selling the shares now...");
        Util.delay(500);

        while (shares > 0 && !transactions.isEmpty()) {
            ShareTransaction transaction = transactions.peekFirst();

            if (transaction.shares() <= shares) {
                transactions.pollFirst(); // Remove the transaction
                totalCapitalGain += transaction.shares() * (price - transaction.price());
                shares -= transaction.shares();
            } else {
                // Adjust the transaction and recalculate capital gain
                totalCapitalGain += shares * (price - transaction.price());
                transactions.pollFirst();
                transactions.addFirst(
                    new ShareTransaction(transaction.shares() - shares, transaction.price()));
                shares = 0;
            }
        }

        if (shares > 0) {
            logError("Not enough shares to sell!");
        }

        System.out.println("Total Capital Gain/ Loss: " + totalCapitalGain);
        printTransactions(transactions);
        return totalCapitalGain;
    }

    public static void printTransactions(Deque<ShareTransaction> transactions) {
        final String delimiter = ", ";
        String sharesString = transactions.stream()
            .map(transaction -> String.valueOf(transaction.shares()))
            .collect(Collectors.joining(delimiter));
        String priceString = transactions.stream()
            .map(transaction -> String.valueOf(transaction.price()))
            .collect(Collectors.joining(delimiter));

        System.out.printf("Queue for Share: [%s]\nQueue for Price: [%s]%n", sharesString,
            priceString);
    }
}