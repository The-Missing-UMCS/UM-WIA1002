package com.umwia1002.solution.tutorial.tutorial3.T3Q1.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Dispenser {
    CANDY("Candy", 1.00),
    CHIP("Chip", 3.80),
    GUM("Gum", 2.50),
    COOKIES("Cookies", 2.50);

    private final String name;
    private final double price;
}
