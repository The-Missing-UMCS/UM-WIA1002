package com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Stock {

    private final int price;
    private int share;

    public boolean sellShare(int share) {
        if (share < this.share) {
            this.share -= share;
            return true;
        }
        return false;
    }

}
