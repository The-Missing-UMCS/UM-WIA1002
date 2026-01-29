package com.umwia1002.solution.lab.version1.lab01.l1q1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static com.umwia1002.solution.util.FileUtil.*;

public class Main {

    private static final String FILE_PATH = chain(LAB_V1_LAB1, IO_FILES, "ZhiYang_22004833.txt");

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_PATH, true))) {
            // 1. Get the  user input
            StringBuilder secondPart = new StringBuilder();

            secondPart.append(System.lineSeparator()) // \n
                .append(System.lineSeparator())
                .append(new SimpleDateFormat("EEEE, d MMMM yyyy").format(new Date()))
                .append(System.lineSeparator());

            System.out.println("Second part: ");
            secondPart.append(scanner.nextLine());

            // 2. Write the user input to the file
            writer.println(secondPart);

            // Flush the writer to ensure the content is written to the file
            // Else the content cannot be read from the file
            writer.flush();

            // 3. Read the content of the file
            System.out.println(readAsString(new File(FILE_PATH)));
        } catch (Exception ex) {
            System.out.println("Error reading file: " + FILE_PATH);
        }
    }

    private static String readAsString(File file) {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return content.toString();
        } catch (Exception ex) {
            return null;
        }
    }
}
