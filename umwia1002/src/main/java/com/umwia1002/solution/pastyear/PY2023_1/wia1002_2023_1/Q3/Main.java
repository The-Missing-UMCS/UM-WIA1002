package com.umwia1002.solution.pastyear.PY2023_1.wia1002_2023_1.Q3;

import java.util.*;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        List<String[]> data = new ArrayList<>();
        String[] headers = null;
        try (Scanner sc = new Scanner(new FileInputStream("src\\wia1002_2023_1\\Q3\\original_data.csv"))) {
            headers = sc.nextLine().split(",");
            while (sc.hasNextLine())
                data.add(sc.nextLine().split(","));
        } catch (Exception ex) {
        }
        printTable(headers, data);
        System.out.println();

        int count = 0;
        double[] average = new double[headers.length];
        for (int i = 0; i < data.size(); i++, count++)
            for (int j = 1; j < headers.length; j++)
                average[j] += Double.parseDouble(data.get(i)[j]);
        for (int i = 0; i < average.length; i++)
            average[i] /= count;

        List<String[]> processedData = new ArrayList<>();
        for (String[] d : data) {
            String[] newRow = new String[d.length];
            for (int i = 0; i < headers.length; i++)
                newRow[i] = i == 0 ? d[i] : String.format("%.2f", Double.parseDouble(d[i]) - average[i]);
            processedData.add(newRow);
        }

        for (int i = 1; i < headers.length; i++)
            headers[i] = headers[i] + " - Ave";
        printTable(headers, processedData);
        System.out.println();

        for (int colNum = 1; colNum < headers.length; colNum++)
            deNoise(colNum, processedData);
        printTable(headers, processedData);
        System.out.println();

        int colNum = 5;
        for (int i = 0; i < processedData.size(); i++) {
            String value = processedData.get(i)[colNum];
            processedData.get(i)[colNum] = value.trim().isEmpty() ? "None"
                    : degreeToCardinal(Double.parseDouble(value));
        }
        printTable(headers, processedData);
    }

    public static void printTable(String[] headers, List<String[]> data) {
        int[] maxWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++)
            maxWidths[i] = headers[i].length();
        for (String[] d : data)
            for (int i = 0; i < headers.length; i++)
                maxWidths[i] = Math.max(maxWidths[i], d[i].length());
        System.out.print("\n|");
        for (int i = 0; i < headers.length; i++)
            System.out.print(" " + padLeft(maxWidths[i], headers[i]) + " |");
        for (String[] d : data) {
            System.out.print("\n|");
            for (int i = 0; i < headers.length; i++)
                System.out.print(" " + padRight(maxWidths[i], d[i]) + " |");
        }
    }

    static String padLeft(int pad, String str) {
        return String.format("%-" + pad + "s", str);
    }

    static String padRight(int pad, String str) {
        return String.format("%" + pad + "s", str);
    }

    static void deNoise(int colNum, List<String[]> dataList) {
        double[] temp = new double[dataList.size() - 2];
        for (int i = 2; i < dataList.size(); i++) {
            temp[i - 2] = findMedian(
                    Double.parseDouble(dataList.get(i)[colNum]),
                    Double.parseDouble(dataList.get(i - 1)[colNum]),
                    Double.parseDouble(dataList.get(i - 2)[colNum]));
        }

        dataList.get(0)[colNum] = " ";
        dataList.get(1)[colNum] = " ";
        for (int i = 2; i < dataList.size(); i++)
            dataList.get(i)[colNum] = String.valueOf(temp[i - 2]);
    }

    static Double findMedian(double v1, double v2, double v3) {
        double[] values = { v1, v2, v3 };
        Arrays.sort(values);
        return values[1];
    }

    static String degreeToCardinal(double degree) {
        String[] directions = {
                "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
                "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"
        };
        double deg = degree < 0 ? 360 - degree : degree;
        return directions[(int) Math.round((((deg + 11.25) % 360) / 22.5))];
    }
}
