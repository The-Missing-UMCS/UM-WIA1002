package com.umwia1002.solution.lab.version2.lab06.l6q2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.umwia1002.solution.util.FileUtil.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 1. Read the content of the file
        String filePath = chain(LAB_V2_LAB6, IO_FILES, "lab6Q2.txt");
        String content = Files.readString(Path.of(filePath));

        // 2. Process the content into the data structure (queue and map)
        Queue<String> codes = new LinkedList<>();
        Map<String, Queue<String>> products = new HashMap<>();
        processContent(content, codes, products);

        // 3. Print the processed data
        printProducts(codes, products);
    }

    private static void processContent(String content,
                                       Queue<String> codes,
                                       Map<String, Queue<String>> products) {
        Pattern pattern = Pattern.compile("(P0\\d)\\s(\\w+)");
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String code = matcher.group(1);
            String product = matcher.group(2);
            if (!codes.contains(code)) {
                codes.add(code);
                products.put(code, new ArrayDeque<>());
            }
            products.get(code).add(product);
        }
    }

    private static void printProducts(Queue<String> codes, Map<String, Queue<String>> products) {
        System.out.println("Product Code in Queue : ");
        printQueue(codes);

        System.out.println("Lists of product by categories");
        for (String code : codes) {
            System.out.println("Product : " + code);
            printQueue(products.get(code));
        }
    }

    private static void printQueue(Queue<String> queue) {
        for (String item : queue) {
            System.out.print(item + " --> ");
        }
        System.out.println();
    }
}
