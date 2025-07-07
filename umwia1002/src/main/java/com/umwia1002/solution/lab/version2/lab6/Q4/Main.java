package com.umwia1002.solution.lab.version2.lab6.Q4;

import com.umwia1002.solution.lab.version2.lab6.Q4.domain.Account;
import com.umwia1002.solution.lab.version2.lab6.Q4.domain.Transaction;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.umwia1002.solution.lab.version2.lab6.Q4.domain.Transaction.Status.BUY;
import static com.umwia1002.solution.lab.version2.lab6.Q4.domain.Transaction.Status.SELL;
import static com.umwia1002.solution.util.FileUtil.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Initialize the transaction history
        String filePath = chain(LAB_V2_LAB6, IO_FILES, "lab6Q4.txt");
        Queue<Transaction> transactionHistory = readTransactionHistory(filePath);

        // 2. Print the transaction history
        int day = 1;
        for (Transaction transaction : transactionHistory) {
            System.out.printf("Day %d : %s -->%n", day++, transaction);
        }

        Account account = Account.createAccount();
        account.process(transactionHistory);
        System.out.println("Total Gain: " + account.getTotalGain());
    }

    public static Queue<Transaction> readTransactionHistory(String path) throws Exception {
        // 1. Initialize a queue to store the transaction history
        Queue<Transaction> transactionHistory = new LinkedList<>();

        // 2. Read the content from files
        String fileContent = Files.readString(Paths.get(path));
        String[] transactionLines = fileContent.split(System.lineSeparator());

        // 3. Transform each transaction line into a Transaction object
        Pattern pattern = Pattern.compile("(Buy|Sell) (\\d+) shares at RM (\\d+)");
        for (String line : transactionLines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                boolean status = "Buy".equals(matcher.group(1));
                int share = Integer.parseInt(matcher.group(2));
                int price = Integer.parseInt(matcher.group(3));
                transactionHistory.add(new Transaction(status ? BUY : SELL, share, price));
            }
        }

        return transactionHistory;
    }
}
