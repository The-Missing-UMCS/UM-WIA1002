package com.umwia1002.solution.tutorial.tutorial3.T3Q1.services;

import com.umwia1002.solution.tutorial.tutorial3.T3Q1.impl.CashRegister;
import com.umwia1002.solution.util.InputUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentService {
    private final CashRegister cashRegister;

    public double processPayment(double price) {
        double totalPaid = 0.0;

        while (totalPaid < price) {
            double payment = InputUtil.getDoubleInput("Current payment: RM %.2f. Enter payment: ".formatted(totalPaid));
            totalPaid += payment;
        }

        return cashRegister.acceptAndReturn(totalPaid, totalPaid - price);
    }
}