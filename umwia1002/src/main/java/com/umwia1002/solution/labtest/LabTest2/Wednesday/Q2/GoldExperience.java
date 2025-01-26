package com.umwia1002.solution.labtest.LabTest2.Wednesday.Q2;

import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

// Might use list.indexOf(String) to replace the Map

public class GoldExperience {
    public static void main(String[] args) {
        final int N = 6;
        final List<List<String>> parcelList = List.of(
                List.of("Jotaro", "Joseph", "Jolyne", "Jotaro", "Joseph", "Jolyne", "Jotaro", "Joseph", "Jolyne",
                        "Jotaro", "Joseph", "Jolyne",
                        "Jotaro", "Joseph", "Jolyne"),
                List.of("DIO"),
                List.of("Babyface", "Beach Boy", "Metallica", "King Crimson", "Beach Boy", "The Grateful Dead",
                        "Beach Boy"),
                List.of("Whitesnake", "Whitesnake", "Whitesnake",
                        "Whitesnake", "Made in Heaven", "Made in Heaven", "Made in Heaven", "Made in Heaven", "C-Moon",
                        "C-Moon", "C-Moon", "C-Moon"),
                List.of("Formaggio", "Formaggio", "Prosciutto", "Illuso",
                        "Melone", "Pesci", "Formaggio", "Ghiaccio", "Pesci", "Sale"),
                List.of("Koichi", "Hayato", "JoJo", "Iggy", "Giorno",
                        "Emporio", "Foo", "DIO", "DIO", "DIO", "DIO", "DIO", "Akira", "Bucciarati",
                        "Akira", "Akira"));
        final List<List<String>> ownerList = List.of(
                List.of("Jolyne", "Joseph", "Jotaro"),
                List.of("DIO"),
                List.of("Babyface", "Beach Boy", "King Crimson",
                        "Metallica", "The Grateful Dead"),
                List.of("C-Moon", "Made in Heaven", "Whitesnake"),
                List.of("Formaggio", "Ghiaccio", "Illuso", "Melone",
                        "Pesci", "Prosciutto", "Sale"),
                List.of("Akira", "Bucciarati", "DIO", "Emporio", "Foo",
                        "Giorno", "Hayato", "Iggy", "JoJo", "Koichi"));
        for (int i = 0; i < N; i++) {
            Stack<Stack<String>> animals = minimumAnimals(parcelList.get(i), ownerList.get(i));
            System.out.printf("Case %d\n", i + 1);
            System.out.printf("Number of animals: %d\n", animals.size());
            for (int j = 0; j < animals.size(); j++) {
                System.out.printf("Animal %d: %s\n", j + 1, animals.get(j));
            }
            System.out.println();
        }
    }

    public static Stack<Stack<String>> minimumAnimals(List<String> parcelList, List<String> ownerList) {
        Map<String, Integer> map = new HashMap<>();
        Stack<Stack<String>> courierList = new Stack<>();

        for (int i = 0; i < ownerList.size(); i++) {
            map.put(ownerList.get(i), i + 1);
        }

        for (String parcel : parcelList) {
            int minIndex = getMinStackIndex(courierList, parcel, map);

            if (minIndex != -1) {
                courierList.get(minIndex).push(parcel);
            } else {
                Stack<String> newCourier = new Stack<>();
                newCourier.push(parcel);
                courierList.push(newCourier);
            }
        }

        return courierList;
    }

    public static int getMinStackIndex(Stack<Stack<String>> courierList, String parcel, Map<String, Integer> map) {
        int minIndex = -1;
        int minOwnerIndex = Integer.MAX_VALUE;

        for (int i = 0; i < courierList.size(); i++) {
            Stack<String> courier = courierList.get(i);
            int ownerIndex = map.getOrDefault(courier.peek(), Integer.MAX_VALUE);

            if (map.get(parcel) <= ownerIndex && ownerIndex < minOwnerIndex) {
                minOwnerIndex = ownerIndex;
                minIndex = i;
            }
        }

        return minIndex;
    }

}
