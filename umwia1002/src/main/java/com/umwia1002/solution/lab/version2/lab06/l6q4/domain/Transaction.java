package com.umwia1002.solution.lab.version2.lab06.l6q4.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {

    private Status status;
    private int share;
    private int price;

    @Override
    public String toString() {
        String statusString = status == Status.BUY ? "Buy" : "Sell";
        return String.format("%s %d share at RM %d", statusString, share, price);
    }

    public enum Status {
        BUY, SELL
    }
}
