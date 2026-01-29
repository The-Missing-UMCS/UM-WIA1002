package com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b.domain;

public record Operation(
    Operation.Type operationType,
    int share,
    int price
) {

    public enum Type {
        BUY, SELL
    }
}
