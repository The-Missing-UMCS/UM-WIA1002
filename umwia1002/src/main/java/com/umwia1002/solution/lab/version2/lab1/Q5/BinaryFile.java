package com.umwia1002.solution.lab.version2.lab1.Q5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;

public class BinaryFile implements FileIO {

    @Override
    public String read(String filePath) {
        validateExtension(filePath);

        Path path = Path.of(filePath);
        checkFileExists(path);

        StringBuilder content = new StringBuilder();

        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))) {
            while (true) {
                content.append(inputStream.readUTF());
                if (inputStream.available() > 0) {
                    content.append(System.lineSeparator());
                }
            }
        } catch (EOFException ignored) {
            // End of file reached; no further action needed
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        return content.toString();
    }

    @Override
    public void write(String filePath, String content, boolean append) {
        validateExtension(filePath);

        Path path = Path.of(filePath);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
            Files.newOutputStream(path, append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE))) {
            outputStream.writeUTF(content);
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

    @Override
    public Set<String> supportedFileExtensions() {
        return Set.of(".dat");
    }
}
