package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Utils;

import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Data;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature.Feature;

import java.util.*;

public class TableUtil {
    public static final int CELL_LENGTH = 20;
    public static final String SYMBOL = "-";

    public static void printFeatureTable(Feature<?> feature, String title, String[] labels) {
        printTable(featureTableContent(feature), title, labels);
    }

    public static void printMergedTable(List<List<?>> list, String title, String[] labels) {
        printTable(mergedTableContent(list), title, labels);
    }

    private static String featureTableContent(Feature<?> feature) {
        StringBuilder sb = new StringBuilder();
        for (Data<?> data : feature.dataList())
            sb.append(String.format("|%s|%s|%s|\n",
                    middleString(data.getUser()),
                    middleString(value(data.getData())),
                    middleString(value(data.getDate()))));
        return sb.toString();
    }

    private static String mergedTableContent(List<List<?>> list) {
        StringBuilder sb = new StringBuilder();
        for(List<?> ls : list) {
            sb.append("|");
            for(Object obj : ls)
                sb.append(middleString(value(obj))).append("|");
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void printTable(String tableContent, String title, String[] labels) {
        final int NUM_OF_LABEL = labels.length;

        // * Print the header
        System.out.println(title);
        printDottedLine(NUM_OF_LABEL);

        System.out.print("|");
        for (String label : labels)
            System.out.print(middleString(label) + '|');
        System.out.println();

        printDottedLine(NUM_OF_LABEL);

        // * Print the table content
        System.out.print(tableContent);

        // * Print the footer
        printDottedLine(NUM_OF_LABEL);
        System.out.println();
    }

    private static String middleString(String str) {
        int space = CELL_LENGTH - str.length();
        int left = space >> 1;
        int right = space - left;
        return String.format("%s%s%s", " ".repeat(left), str, " ".repeat(right));
    }

    private static String value(Object obj) {
        if (obj == null)
            return "null";
        else if (obj instanceof Double)
            return String.format("%.2f", (Double) obj);
        else
            return obj.toString();
    }

    private static void printDottedLine(int numOfLabel) {
        System.out.print("|");
        for (int i = 0; i < numOfLabel; i++)
            System.out.print(SYMBOL.repeat(CELL_LENGTH) + "|");
        System.out.println();
    }
}
