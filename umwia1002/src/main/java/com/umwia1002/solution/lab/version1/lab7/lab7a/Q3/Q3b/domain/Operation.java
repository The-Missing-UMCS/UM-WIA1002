package com.umwia1002.solution.lab.version1.lab7.lab7a.Q3.Q3b.domain;

public record Operation(Operation.Type operationType, int share, int price) {
    public enum Type {
        BUY, SELL
    }
}
