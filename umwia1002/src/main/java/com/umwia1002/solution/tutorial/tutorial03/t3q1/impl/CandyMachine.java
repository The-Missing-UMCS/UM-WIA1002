package com.umwia1002.solution.tutorial.tutorial03.t3q1.impl;

import com.umwia1002.solution.tutorial.tutorial03.t3q1.services.InventoryService;
import com.umwia1002.solution.tutorial.tutorial03.t3q1.services.PaymentService;
import com.umwia1002.solution.util.InputUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CandyMachine {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public static CandyMachine getInstance(List<Dispenser> dispensers, double initialBalance) {
        InventoryService inventoryService = new InventoryService(dispensers);
        PaymentService paymentService = new PaymentService(new CashRegister(initialBalance));
        return new CandyMachine(inventoryService, paymentService);
    }

    public void operate() {
        System.out.printf("Available products: %s%n", inventoryService.getAvailableItems());

        int choice = InputUtil.getIntInput(
            "Your choice (1-%d): ".formatted(inventoryService.getItemCount()));
        Dispenser selectedItem = inventoryService.selectItem(choice);

        System.out.printf("Price: RM %.2f%n", selectedItem.getPrice());
        double change = paymentService.processPayment(selectedItem.getPrice());

        System.out.printf("Change: RM %.2f%n", change);
        System.out.printf("%s has been dispensed. Thank you for your purchase.%n",
            selectedItem.getName());
    }
}