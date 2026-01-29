package com.umwia1002.solution.lab.version2.lab09;

import com.umwia1002.solution.lab.version2.lab09.helpers.Product;
import com.umwia1002.solution.lab.version2.lab09.helpers.ProductProvider;
import com.umwia1002.solution.lab.version2.lab09.impl.ArrayHashTable;
import com.umwia1002.solution.lab.version2.lab09.impl.LinearProbeArrayHashTable;

import java.util.List;
import java.util.Scanner;

public class l9q4 {

    public static void main(String[] args) {
        List<Product> products = ProductProvider.fetchProducts();
        if (products.isEmpty()) {
            System.out.println("No data found.");
            return;
        }

        System.out.println("The data set from the File");
        for (Product product : products) {
            System.out.printf("%d : %s%n", product.pid(), product.description());
        }

        ArrayHashTable<Integer, String> table = new LinearProbeArrayHashTable<>(products.size());
        for (Product product : products) {
            table.put(product.pid(), product.description());
        }

        System.out.printf("The Hash Table size is %d%n", table.getCapacity());

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a PID to search : ");
            int pid = Integer.parseInt(scanner.nextLine().trim());
            String value = table.get(pid);
            if (value == null) {
                System.out.printf("Product ID %d cannot be found%n", pid);
            } else {
                System.out.printf("Product ID : %d  %s%n", pid, value);
                int location = table.indexOf(pid);
                System.out.printf("Location : %d%n", location + 1);
            }
        }
    }
}
