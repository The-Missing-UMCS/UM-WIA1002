package com.umwia1002.solution.lab.version2.lab06.l6q4.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@RequiredArgsConstructor
public class Account {

    private final Queue<Stock> stockQueue;

    @Getter
    private int totalGain;

    public static Account createAccount() {
        return new Account(new LinkedList<>());
    }

    public void process(Queue<Transaction> history) {
        while (!history.isEmpty()) {
            Transaction transaction = history.poll();
            if (transaction.getStatus() == Transaction.Status.BUY) {
                buy(transaction.getShare(), transaction.getPrice());
            } else {
                sell(transaction.getShare(), transaction.getPrice());
            }
        }
    }

    private void buy(int share, int price) {
        stockQueue.add(new Stock(share, price));
    }

    private void sell(int share, int price) {
        while (share > 0 && !stockQueue.isEmpty()) {
            Stock stock = stockQueue.peek();
            int shareSold = Math.min(stock.getShare(), share);
            totalGain += shareSold * (price - stock.getPrice());
            if (!stock.checkAndSellShare(shareSold)) {
                stockQueue.poll();
            }

            share -= shareSold;
        }
        if (share > 0) {
            throw new IllegalStateException("Insufficient stock to sell");
        }
    }
}
