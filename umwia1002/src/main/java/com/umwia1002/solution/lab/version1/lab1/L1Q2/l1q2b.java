package com.umwia1002.solution.lab.version1.lab1.L1Q2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.umwia1002.solution.util.ConsoleUtil.logRed;
import static com.umwia1002.solution.util.FileUtil.*;

public class l1q2b {
    private static final String FOLDER = chain(LAB_V1_LAB1, IO_FILES, "L1Q2");

    public static void main(String[] args) throws Exception {
        getFiles().forEach(l1q2b::printFile);
    }

    private static void printFile(File file) {
        try {
            // 1. Print Header
            logRed("--> %s <--".formatted(file.getName()));

            // 2. Get content of the file
            String content = Files.readString(Path.of(file.getAbsolutePath()));

            // 3. Print content
            Arrays.stream(content.split(System.lineSeparator()))
                .map(line -> String.join("", line.split("[\\s,;]+")))
                .forEach(System.out::println);

            // 4. Print character count
            System.out.printf("Character count = %d %n%n", countCharacters(content));
        } catch (Exception ex) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    private static List<File> getFiles() {
        File[] listOfFiles = new File(FOLDER).listFiles((_, name) -> name.endsWith(".txt"));
        return Objects.isNull(listOfFiles) ? List.of() : Arrays.asList(listOfFiles);
    }

    private static long countCharacters(String content) {
        return content.chars()
            .filter(ch -> Character.isLetterOrDigit(ch) || ch == '.')
            .count();
    }
}
