package com.umwia1002.solution.pastyear.py2023s2.Q5;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // "АБЦЧДЕЁЭФГХИЙЯЮКЛМНОП.РСШЩТУВ..ЫЖЗЬЪ";
        String[] names = {
                "DAVID", "ELIZABETH", "JAMES", "JENNIFER", "JOHN",
                "LINDA", "MARIA", "MICHAEL", "PATRICIA", "ROBERT",
                "АНТОНОВ", "ВОЛКОВ", "ГУРИН", "ИВАНОВ", "КОЛМОГОРОВ",
                "МАРЧА", "МАРКОВ", "ПЕТРОВ", "ПУТИН", "СТЕПАНОВ"
        };

        Comparator<String> comparator = new SpecialComparator<>();
        sort(names, comparator);

        String delimiter = "\n - ";
        System.out.print("# Sorted name list:" + delimiter);
        printArray(names, "\n - ");

        delimiter = "\n   ";
        System.out.print("\n\n# Search" + delimiter);
        System.out.printf("Index of АНТОНОВ: %d%s", search(names, "АНТОНОВ"), delimiter);
        System.out.printf("Index of MARKOV: %d%s", search(names, "MARKOV"), delimiter);
        System.out.printf("Index of МАРЧА: %d%s", search(names, "МАРЧА"), delimiter);
        System.out.printf("Index of ВОЛКОВ: %d%s", search(names, "ВОЛКОВ"), delimiter);

        System.out.println("\n# Find Max");
        int maxIndex = findMax(names, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Longest name = " + names[maxIndex]);
        System.out.println("Index = " + maxIndex);

    }

    public static void sort(String[] a, Comparator<String> c) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            String key = a[i];
            while (j >= 0 && c.compare(a[j], key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void printArray(String[] a, String delimiter) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + (i == a.length - 1 ? "" : delimiter));
    }

    public static <E extends CharSequence> int search(E[] a, E target) {
        for (int i = 0; i < a.length; i++)
            if (target.equals(a[i]))
                return i;
        return -1;
    }

    public static <E extends CharSequence> int findMax(E[] a, Comparator<E> c) {
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++)
            if (c.compare(a[i], a[maxIndex]) > 0)
                maxIndex = i;
        return maxIndex;
    }
}
