package com.umwia1002.solution.lab.version2.lab1.Q5;

import org.apache.commons.lang3.Validate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public interface FileIO {

    String read(String filePath);

    void write(String filePath, String content, boolean append);

    Set<String> supportedFileExtensions();

    /**
     * Validates that the file extension is supported.
     */
    default void validateExtension(String filePath) {
        String extension = filePath.substring(filePath.lastIndexOf("."));
        Validate.isTrue(supportedFileExtensions().contains(extension),
            "Unsupported file extension: " + extension);
    }

    /**
     * Checks whether the file exists at the given path.
     */
    default void checkFileExists(Path path) {
        Validate.isTrue(Files.exists(path), "File not found at: " + path);
    }
}
