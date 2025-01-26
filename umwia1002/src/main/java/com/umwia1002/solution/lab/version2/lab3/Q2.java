package com.umwia1002.solution.lab.version2.lab3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.umwia1002.solution.util.FileUtil.*;

/**
 * Reverses the content of a file and writes it to another file.
 */
public class Q2 {
    public static void main(String[] args) {
        Path inputPath = Path.of(chain(LAB_V2_LAB3, IO_FILES, "text.txt"));
        Path outputPath = Path.of(chain(LAB_V2_LAB3, IO_FILES, "reverse.txt"));

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             PrintWriter writer = new PrintWriter(Files.newBufferedWriter(outputPath))) {

            reverseFile(reader, writer);

            Desktop desktop = Desktop.getDesktop();
            desktop.open(inputPath.toFile());
            desktop.open(outputPath.toFile());

        } catch (IOException _) {
        }
    }

    /**
     * Recursively reverses the lines in a file and writes them to the output file.
     *
     * @param reader the BufferedReader for reading the input file
     * @param writer the PrintWriter for writing the reversed lines to the output file
     * @throws IOException if an I/O error occurs
     */
    public static void reverseFile(BufferedReader reader, PrintWriter writer) throws IOException {
        String line = reader.readLine();
        if (line != null) {
            reverseFile(reader, writer);
            writer.println(line);
            writer.flush();
        }
    }
}
