package com.umwia1002.solution.lab.version2.lab09;

import com.umwia1002.solution.lab.version2.lab09.helpers.Product;
import com.umwia1002.solution.lab.version2.lab09.helpers.ProductProvider;
import com.umwia1002.solution.lab.version2.lab09.impl.HashChainArrayHashTable;

import java.util.List;
import java.util.Scanner;

public class l9q5 {

    public static void main(String[] args) {
        List<Product> products = ProductProvider.fetchProducts();
        if (products.isEmpty()) {
            System.out.println("No data found.");
            return;
        }

        System.out.println("The data set from the File");
        for (Product product : products) {
            System.out.println(product.pid() + " : " + product.description());
        }

        HashChainArrayHashTable<Integer, String> table =
            new HashChainArrayHashTable<>(products.size());
        for (Product product : products) {
            table.put(product.pid(), product.description());
        }

        System.out.println("Hash Table using Hash Chain");
        System.out.println("The Hash Table size is " + table.getCapacity());

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a PID to search : ");
            int pid = Integer.parseInt(scanner.nextLine().trim());
            String value = table.get(pid);
            if (value == null) {
                System.out.println("Product ID " + pid + " cannot be found");
                return;
            }

            System.out.println("Product ID : " + pid + "  " + value);
            System.out.println("The elements in the same location are :");
            List<HashChainArrayHashTable.Entry<Integer, String>> chain = table.getChain(
                pid);
            for (HashChainArrayHashTable.Entry<Integer, String> entry : chain) {
                System.out.print(entry.key + " : " + entry.value + " --> ");
            }
            System.out.println();
        }
    }
}
