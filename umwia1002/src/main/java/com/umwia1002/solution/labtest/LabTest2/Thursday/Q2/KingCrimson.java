package com.umwia1002.solution.labtest.LabTest2.Thursday.Q2;

import java.util.Stack;

public class KingCrimson {
    public static void main(String[] args) {
        final int N = 8;
        final String[][] initialOrderArray = {
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Jolyne", "Giorno", "Josuke", "Jotaro", "Joseph",
                        "Jonathan" },
                { "DIO", "Kira", "Pucci" }
        };
        final String[][] finalOrderArray = {
                { "Hermit Purple", "Hierophant Green", "Magician Red",
                        "Silver Chariot", "Star Platinum" },
                { "Star Platinum", "Silver Chariot", "Hermit Purple",
                        "Hierophant Green", "Magician Red" },
                { "Hermit Purple", "Silver Chariot", "Magician Red",
                        "Hierophant Green", "Star Platinum" },
                { "Magician Red", "Silver Chariot", "Hierophant Green", "Star Platinum", "Hermit Purple" },
                { "Magician Red", "Silver Chariot", "Hierophant Green",
                        "Hermit Purple", "Star Platinum" },
                { "Silver Chariot", "Magician Red", "Star Platinum",
                        "Hierophant Green", "Hermit Purple" },
                { "Jonathan", "Joseph", "Jotaro", "Josuke", "Giorno",
                        "Jolyne" },
                { "Pucci", "DIO", "Kira" }
        };
        for (int i = 0; i < N; i++) {
            System.out.printf("Case %d\n", i + 1);
            System.out.println(getActions(initialOrderArray[i],
                    finalOrderArray[i]));
        }
    }

    public static String getActions(String[] initialOrder, String[] finalOrder) {
        final Stack<String> resident = new Stack<>();
        final Stack<String> foyer = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String message = "%s Diavalo instructs %s to enter the %s%n";
        int instructionCount = 0;

        // Stack-based queue
        for (int i = initialOrder.length - 1; i >= 0; i--) {
            resident.push(initialOrder[i]);
        }

        int residentIndex = 0;

        while (!resident.isEmpty()) {
            if (resident.peek().equals(finalOrder[residentIndex])) {
                sb.append(String.format(message, ++instructionCount, resident.pop(), "college"));
                residentIndex++;
                continue;
            }

            if (!foyer.isEmpty() && foyer.peek().equals(finalOrder[residentIndex])) {
                sb.append(String.format(message, ++instructionCount, foyer.pop(), "college"));
                residentIndex++;
                continue;
            }

            foyer.push(resident.peek());
            sb.append(String.format(message, ++instructionCount, resident.pop(), "foyer"));
        }

        while(!foyer.isEmpty()) {
            if(foyer.peek().equals(finalOrder[residentIndex])) {
                sb.append(String.format(message, ++instructionCount, foyer.pop(), "college"));
                residentIndex++;
            } else {
                break;
            }
        }

        return foyer.isEmpty() ? sb.toString() : "KING CRIMSON!!!\n";
    }
}
