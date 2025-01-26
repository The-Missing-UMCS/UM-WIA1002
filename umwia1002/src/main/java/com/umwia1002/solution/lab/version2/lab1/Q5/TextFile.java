package com.umwia1002.solution.lab.version2.lab1.Q5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;
import java.util.stream.Collectors;

public class TextFile implements FileIO {

    @Override
    public String read(String filePath) {
        validateExtension(filePath);

        Path path = Path.of(filePath);
        checkFileExists(path);

        try (var lines = Files.lines(path)) {
            return lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
            return "";
        }
    }

    @Override
    public void write(String filePath, String content, boolean append) {
        validateExtension(filePath);

        Path path = Path.of(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(
            path, append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE)) {
            writer.write(content);
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

    @Override
    public Set<String> supportedFileExtensions() {
        return Set.of(".txt");
    }
}
