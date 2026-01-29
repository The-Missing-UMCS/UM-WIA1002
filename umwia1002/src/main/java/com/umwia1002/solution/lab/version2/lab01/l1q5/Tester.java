package com.umwia1002.solution.lab.version2.lab01.l1q5;

import org.apache.commons.lang3.StringUtils;

import static com.umwia1002.solution.util.FileUtil.*;

public class Tester {

    public static void main(String[] args) {
        FileIO textFile = new TextFile();
        FileIO binaryFile = new BinaryFile();
        String content = """
            Welcome to FSKTM!
            Please register your matric number.
            Please register your UMMail account.
            """;

        String textFilePath = chain(LAB_V2_LAB1, IO_FILES, "content.txt");
        String binFilePath = chain(LAB_V2_LAB1, IO_FILES, "content.dat");

        writeFile(textFile, FileType.TEXT, textFilePath, content, false);
        readFile(textFile, FileType.TEXT, textFilePath);
        writeFile(binaryFile, FileType.BINARY, binFilePath, content, false);
        readFile(binaryFile, FileType.BINARY, binFilePath);
    }

    private static void readFile(FileIO fileReader, FileType type, String filePath) {
        System.out.printf("Read from %s%n", StringUtils.capitalize(type.name().toLowerCase()));
        String content = fileReader.read(filePath);
        if (!content.isEmpty()) {
            System.out.println(content);
        }
    }

    private static void writeFile(FileIO fileWriter, FileType type, String filePath, String content, boolean append) {
        System.out.printf("Write to %s%n", StringUtils.capitalize(type.name().toLowerCase()));
        System.out.print(content);
        fileWriter.write(filePath, content, append);
    }

    enum FileType {
        TEXT, BINARY
    }
}
