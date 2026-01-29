package com.umwia1002.solution.lab.version2.lab08.l8q2;

import com.umwia1002.solution.lab.version2.lab08.impl.SortingAlgorithms;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.umwia1002.solution.util.FileUtil.*;

public class Main {

    private static final String FILE_PATH = chain(LAB_V2_LAB8, IO_FILES, "lab8Q2.txt");

    public static void main(String[] args) {
        List<Product> products = readProducts();
        System.out.println("Reading data from product text file");
        printProducts(products);

        Product[] sorted = products.toArray(new Product[0]);
        SortingAlgorithms.dualPivotQuickSort().sort(sorted, Comparator.comparing(Product::price));
        for (int i = 0; i < sorted.length; i++) {
            products.set(i, sorted[i]);
        }

        System.out.println("After Quick Sort (Price, PID) ");
        printProducts(products);
    }

    private static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.printf("%s :  %s : %.2f : %d%n", product.pid(), product.sid(),
                product.price(), product.quantity());
        }
    }

    private static List<Product> readProducts() {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(FILE_PATH))
                .stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Product(
                        parts[0],
                        parts[1],
                        new BigDecimal(parts[2]),
                        Integer.parseInt(parts[3])
                    );
                })
                .toList());
        } catch (IOException exception) {
            throw new RuntimeException("Failed to read products file", exception);
        }
    }

    record Product(
        String pid,
        String sid,
        BigDecimal price,
        int quantity
    ) {

    }
}



