package com.umwia1002.solution.tutorial.tutorial07.tutorial7a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class t7aQ3 {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Scanner keyIn = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            if (keyIn.nextBoolean()) {
                System.out.print(i + " ");
            } else {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
        System.out.println();

        keyIn.close();

        // a) 1 4 5 2 3
        // b) No. 2 comes before 4, therefore 2 will be in front of 4
        // c)
        // 1. true true true true true
        // 2. true true true true false
        // 3. true true true false false
        // 4. true true false false false
        // 5. true false false false false
        // 6. false false false false false

    }
}
