package com.umwia1002.solution.lab.version2.lab06.l6q4.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Stock {

    private int share;
    private final int price;

    public boolean checkAndSellShare(int share) {
        if (share < this.share) {
            this.share -= share;
            return true;
        }
        return false;
    }
}
