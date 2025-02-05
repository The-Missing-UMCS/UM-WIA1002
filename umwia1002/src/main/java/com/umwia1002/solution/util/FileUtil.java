package com.umwia1002.solution.util;

import java.io.File;

public class FileUtil {
    public static final String ROOT = "src/main/java/com/umwia1002/solution";
    public static final String LAB = "lab";
    public static final String TUTORIAL = "tutorial";
    public static final String V1 = "version1";
    public static final String V2 = "version2";
    public static final String IO_FILES = "io_files";

    public static final String LAB1 = "lab1";
    public static final String LAB3 = "lab3";
    public static final String LAB5 = "lab5";
    public static final String LAB6 = "lab6";
    public static final String LAB7 = "lab7";

    public static final String LAB_V1_LAB1 = chain(ROOT, LAB, V1, LAB1);
    public static final String LAB_V1_LAB7 = chain(ROOT, LAB, V1, LAB7);
    public static final String LAB_V2_LAB1 = chain(ROOT, LAB, V2, LAB1);
    public static final String LAB_V2_LAB3 = chain(ROOT, LAB, V2, LAB3);
    public static final String LAB_V2_LAB5 = chain(ROOT, LAB, V2, LAB5);
    public static final String LAB_V2_LAB6 = chain(ROOT, LAB, V2, LAB6);

    public static String chain(String... args) {
        return String.join(File.separator, args);
    }
}
