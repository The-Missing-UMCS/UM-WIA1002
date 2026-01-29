package com.umwia1002.solution.lab.version2.lab05.l5q5;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.umwia1002.solution.util.FileUtil.*;

public class Main {

    private static final String XML_FILES_PATH = chain(LAB_V2_LAB5, IO_FILES, XML_FILES);
    private static final Pattern TAG_PATTERN = Pattern.compile("<(/?)(\\w+)>");

    public static void main(String[] args) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(XML_FILES_PATH))) {
            for (Path filePath : stream) {
                String fileContent = Files.readString(filePath);
                validateXml(fileContent);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void validateXml(String xmlContent) {
        Stack<String> tagStack = new Stack<>();
        boolean hasRoot = false;
        boolean isValid = true;
        Matcher tagMatcher = TAG_PATTERN.matcher(xmlContent);

        System.out.println(xmlContent);
        while (tagMatcher.find() && isValid) {
            boolean isClosingTag = tagMatcher.group(1).equals("/");
            String tag = tagMatcher.group();
            String tagName = tagMatcher.group(2);

            if (isClosingTag) {
                if (tagStack.isEmpty() || !tagStack.peek().equals(tagName)) {
                    System.out.printf("Begin Element : <%s> Invalid ending element : %s\n",
                        tagStack.peek(), tag);
                    isValid = false;
                } else {
                    tagStack.pop();
                }
            } else {
                if (tagName.equals("note")) {
                    if (hasRoot) {
                        System.out.println("Duplicate root element <note>");
                        isValid = false;
                        continue;
                    }
                    hasRoot = true;
                }
                tagStack.push(tagName);
            }
        }

        if (isValid && !tagStack.isEmpty()) {
            System.out.printf("Begin Element : <%s> No closing element\n", tagStack.pop());
        }

        if (isValid && tagStack.isEmpty()) {
            System.out.println("The xml document is valid");
        }

        System.out.println();
    }
}
