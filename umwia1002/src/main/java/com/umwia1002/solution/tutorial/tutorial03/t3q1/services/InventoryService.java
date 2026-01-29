package com.umwia1002.solution.tutorial.tutorial03.t3q1.services;

import com.umwia1002.solution.tutorial.tutorial03.t3q1.impl.Dispenser;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class InventoryService {

    private final List<Dispenser> dispensers;

    public String getAvailableItems() {
        return dispensers.stream().map(Dispenser::getName).collect(Collectors.joining(", "));
    }

    public int getItemCount() {
        return dispensers.size();
    }

    public Dispenser selectItem(int index) {
        if (index < 1 || index > dispensers.size()) {
            throw new IllegalArgumentException("Invalid selection. Please choose a valid item.");
        }
        return dispensers.get(index - 1);
    }
}
