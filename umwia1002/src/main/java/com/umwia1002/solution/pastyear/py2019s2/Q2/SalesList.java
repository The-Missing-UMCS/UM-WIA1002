package com.umwia1002.solution.pastyear.py2019s2.Q2;

public class SalesList {
    String region;
    Integer salesAmount;
    String salesRepresentative;

    SalesList() {
        
    }

    SalesList(String region, Integer salesAmount, String salesRepresentative) {
        this.region = region;
        this.salesAmount = salesAmount;
        this.salesRepresentative = salesRepresentative;
    }

    public String toString() {
        return String.format("%-10s %d %-10s", region, salesAmount, salesRepresentative);
    }
}
