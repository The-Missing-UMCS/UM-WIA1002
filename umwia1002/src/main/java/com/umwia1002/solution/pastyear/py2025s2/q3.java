package com.umwia1002.solution.pastyear.py2025s2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class q3 {
    public static void main(String[] args) {
        final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        CircularQueue<String> queue = new CircularQueue<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String matricNo = String.format("%c%d", alphabets.charAt(rand.nextInt(alphabets.length())), rand.nextInt(10000000, 99999999));
            queue.enqueue(matricNo);
            System.out.printf("Random matric number: %s%n", matricNo);
        }
        System.out.println(queue);

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
            int cmp = Integer.compare(s1.charAt(0), s2.charAt(0));
            if (cmp != 0) {
                return cmp;
            }
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            for (int i = 1; i < s1.length(); i++) {
                if ((cmp = Integer.compare(chars1[i], chars2[2])) != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        pq.enqueue("J43893080");
        pq.enqueue("I36799067");
        pq.enqueue("V52273265");
        pq.enqueue("V16459281");
        pq.enqueue("Q91277894");
        System.out.println(pq);

    }

    static class CircularQueue<E> {
        @SuppressWarnings("unchecked")
        E[] arr = (E[]) new Object[8];
        int front = -1;
        int end = -1;

        public CircularQueue() {
        }

        void enqueue(E elem) {
            end = (end + 1) % 8;
            arr[end] = elem;
            if (end == front) {
                front = (front + 1) % 8;
            }
            if (front == -1) {
                front = 0;
            }
        }

        E dequeue() {
            if (arr[front] == null) {
                return null;
            }
            E elem = arr[front];
            arr[front++] = null;
            return elem;
        }

        @Override
        public String toString() {
            String[] vals = new String[8];
            int i = front, index = 0;
            do {
                vals[index++] = arr[i] != null ? arr[i].toString() : "";
                i = (i + 1) % 8;
            } while (i != end + 1);
            return String.join(",", vals);
        }
    }

    static class PriorityQueue<E> {
        final Comparator<E> comparator;

        @SuppressWarnings("unchecked")
        E[] arr = (E[]) new Object[8];
        int size;

        public PriorityQueue(Comparator<E> comparator) {
            this.comparator = comparator;
        }

        void enqueue(E elem) {
            int child = size++;
            if (size == 1) {
                arr[child] = elem;
                return;
            }

            for (int parent = (child - 1) / 2; parent >= 0 && comparator.compare(elem, arr[parent]) > 0; ) {
                arr[child] = arr[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            arr[child] = elem;
        }

        E dequeue() {
            return null;
        }

        @Override
        public String toString() {
            return Arrays.deepToString(arr);
        }
    }
}
