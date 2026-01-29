package com.umwia1002.solution.lab.version2.lab09.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static com.umwia1002.solution.util.FileUtil.*;

public class ProductProvider {

    private static final String DATA_FILE = chain(LAB_V2_LAB9, IO_FILES, "lab9Q4.txt");

    public static List<Product> fetchProducts() {
        try {
            return Files.readAllLines(Paths.get(DATA_FILE)).stream()
                .filter(line -> !line.isBlank())
                .map(ProductProvider::convertToProduct)
                .filter(Objects::nonNull)
                .toList();
        } catch (IOException | NumberFormatException e) {
            return List.of();
        }
    }

    private static Product convertToProduct(String line) {
        String[] parts = line.split(",", 2);
        if (parts.length < 2) {
            return null;
        }
        int pid = Integer.parseInt(parts[0].trim());
        String description = parts[1].trim();
        return new Product(pid, description);
    }
}
