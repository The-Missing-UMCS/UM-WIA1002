package com.umwia1002.solution.pastyear.PY2023_1.wia1002_2023_1.Q4;

import java.util.*;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        final String DIR = "src\\wia1002_2023_1\\Q4\\";
        // For printing purpose
        String[] headers1 = null, headers2 = null, headers3 = null;
        List<String[]> ls1 = null, ls2 = null, ls3 = null; // ls3 will be used in final output

        // For final output
        HashMap<String, String[]> patients = new HashMap<>();
        HashMap<String, String> families = new HashMap<>();

        try (Scanner sc = new Scanner(new FileInputStream(DIR + "past_medical_record.csv"))) {
            headers1 = sc.nextLine().split(",");
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                patients.put(data[0] + " " + data[1], data);
            }
            ls1 = new ArrayList<>(patients.values());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try (Scanner sc = new Scanner(new FileInputStream(DIR + "family_book.csv"))) {
            headers2 = sc.nextLine().split(",");
            ls2 = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                ls2.add(data);
                families.put(data[0] + " " + data[1], data[2] + " " + data[3]);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try (Scanner sc = new Scanner(new FileInputStream(DIR + "upcoming_patients.csv"))) {
            headers3 = sc.nextLine().split(",");
            ls3 = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                ls3.add(data);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        printTable(headers1, ls1, "");
        printTable(headers2, ls2, "");
        printTable(headers3, ls3, "");

        List<String[]> combined = new ArrayList<>();
        for (String[] up : ls3) { // upcoming patient
            String parentName = families.get(up[0] + " " + (up.length > 1 ? up[1] : ""));
            String[] parent = patients.get(parentName);
            combined.add(parent == null ? up : combineArray(up, parent));
        }

        // Generate headers4
        String[] headers4 = combineArray(headers3, headers1);
        for (int i = headers3.length; i < headers4.length; i++)
            headers4[i] = "Parent" + headers4[i];
        printTable(headers4, combined, "None");
    }

    public static String[] combineArray(String[] a1, String[] a2) {
        String[] res = new String[a1.length + a2.length];
        System.arraycopy(a1, 0, res, 0, a1.length);
        System.arraycopy(a2, 0, res, a1.length, a2.length);
        return res;
    }

    public static void printTable(String[] headers, List<? extends String[]> list, String alt) {
        int[] maxWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++)
            maxWidths[i] = headers[i].length();
        for (String[] data : list)
            for (int i = 0; i < headers.length; i++)
                maxWidths[i] = Math.max(maxWidths[i], i < data.length ? data[i].length() : 0);

        System.out.print("|");
        for (int i = 0; i < headers.length; i++)
            System.out.printf(" %" + maxWidths[i] + "s |", headers[i]);
        System.out.print("\n|");
        for (int i = 0; i < headers.length; i++)
            System.out.printf("%" + (maxWidths[i] + 1) + "s |", "-".repeat(maxWidths[i] + 1));

        for (String[] data : list) {
            System.out.print("\n|");
            for (int i = 0; i < headers.length; i++)
                System.out.printf(" %" + maxWidths[i] + "s" + " |", i < data.length ? data[i] : alt);
        }
        System.out.println("\n");
    }
}
