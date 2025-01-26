package com.umwia1002.solution.lab.version2.lab6.Q4;

import java.util.Queue;
import java.util.LinkedList;

public class Account {
	private Queue<Stock> stockQueue;
	private int totalGain;

	Account() {
		stockQueue = new LinkedList<>();
	}

	public int getTotalGain() {
		return this.totalGain;
	}

	public void process(Queue<Transaction> history) {
		while (!history.isEmpty()) {
			Transaction transaction = history.remove();
			if (transaction.getStatus() == Transaction.BUY)
				buy(transaction.getShare(), transaction.getPrice());
			else
				sell(transaction.getShare(), transaction.getPrice());

		}
	}

	private void buy(int share, int price) {
		stockQueue.add(new Stock(share, price));
	}

	private void sell(int share, int price) {
		while (share > 0 && !stockQueue.isEmpty()) {
			Stock stock = stockQueue.peek();
			int sell = Math.min(stock.getShare(), share);
			totalGain += sell * (price - stock.getPrice());

			if (stock.getShare() < share) {
				share -= stockQueue.remove().getShare();
			} else {
				stock.sell(share);
				share = 0;
			}
		}
	}
}
