package com.umwia1002.solution.labtest.LabTest2.Friday.Q2;

import java.util.Stack;

public class DirtyDeedsDoneDirtCheap {
    public static void displayAnswers(String[] actions) {
        final Stack<String> stack1 = new Stack<>();
        final Stack<String> stack2 = new Stack<>();

        for(String action : actions) {
            String[] actionInfo = action.split(" ");
            if(actionInfo.length == 1) {
                System.out.println(stack1.isEmpty() ? "In Original Dimension" : stack1.peek());
            } else if(actionInfo[0].equals("Travel")) {
                stack1.push(action.substring(7));
            } else if(actionInfo[0].equals("Destroy")) {
                while(!stack1.isEmpty()) {
                    if(!stack1.peek().equals(action.substring(8))) {
                        stack2.push(stack1.pop());
                    } else {
                        stack1.pop();
                        stack2.clear();
                    }
                }
                while(!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        final String[][] actionArray = {
                { "Travel Three Kingdoms", "Travel Suzume Door", "Travel JOJOLands", "Ask", "Travel FaceBook",
                        "Travel JOJOLands", "Travel Trading World", "Ask", "Destroy JOJOLands", "Ask",
                        "Travel FaceBook", "Ask", " Travel Trading World", "Travel Three Kingdoms", "Ask",
                        "Destroy Three Kingdoms", "Ask" },

                { "Travel Morioh", "Travel Colosseum", "Travel Cape Canaveral", "Ask", "Travel Morioh",
                        "Travel Sardinia", "Destroy Morioh", "Destroy Devil's Palm", "Ask", "Travel Cape Canaveral",
                        "Ask", "Travel Colosseum", "Destroy Sardinia", "Ask", "Travel Naples", "Destroy Colosseum",
                        "Ask" },

                { "Ask", "Travel Jade Garden", "Travel Cafe Deux Magots", "Ask", "Travel Trattoria Trussardi",
                        "Travel Jade Garden", "Travel Cafe DeuxMagots", "Travel Trattoria Trussardi", "Ask",
                        "Destroy Trattoria Trussardi", "Ask", "Travel Libeccio", "Travel Cafe Deux Magots",
                        "Travel Jade Garden", "Travel Savage Garden", "Destroy Libeccio", "Ask",
                        "Destroy Savage Garden", "Destroy Cafe Deux Magots", "Ask" } 
            };

        for (int i = 0; i < actionArray.length; i++) {
            System.out.printf("Case %d\n", i + 1);
            displayAnswers(actionArray[i]);
            System.out.println();
        }

    }
}
