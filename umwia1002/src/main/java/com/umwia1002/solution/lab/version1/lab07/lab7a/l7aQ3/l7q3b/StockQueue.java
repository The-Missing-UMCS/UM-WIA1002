package com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b;

import com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b.domain.Operation;
import com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b.domain.Stock;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import static com.umwia1002.solution.util.ConsoleUtil.logError;

public class StockQueue {

    private final Queue<Stock> stockQueue;

    @Getter
    private int totalGain;

    StockQueue() {
        stockQueue = new LinkedList<>();
    }

    public void execute(Operation operation) {
        if (operation.operationType() == Operation.Type.BUY) {
            buy(operation.share(), operation.price());
        } else {
            sell(operation.share(), operation.price());
        }
    }

    public void buy(int share, int price) {
        stockQueue.offer(new Stock(price, share));
    }

    public void sell(int share, int price) {
        while (share > 0) {
            if (stockQueue.isEmpty()) {
                logError("No shares to sell!");
                return;
            }
            Stock stock = stockQueue.peek();
            int shareSold = Math.min(share, stock.getShare());
            totalGain += shareSold * (price - stock.getPrice());

            if (!stock.sellShare(shareSold)) {
                stockQueue.remove();
            }

            share -= shareSold;
        }
    }

    @Override
    public String toString() {
        final String delimiter = ", ";
        String sharesString = stockQueue.stream()
            .map(stock -> String.valueOf(stock.getShare())).collect(Collectors.joining(delimiter));
        String priceString = stockQueue.stream()
            .map(stock -> String.valueOf(stock.getPrice())).collect(Collectors.joining(delimiter));

        return String.format("Queue for Share: [%s]\nQueue for Price: [%s]", sharesString,
            priceString);
    }


}
