package com.experiments.book.component.test.helpers;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static java.nio.charset.Charset.defaultCharset;
import static java.util.Objects.requireNonNull;

public class TestFileHelper {

    private TestFileHelper(){}

    public static String readFile(String filePath) {
        try {
            return IOUtils.toString(requireNonNull(getSystemResourceAsStream(filePath)), defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("File not found. File Name: " + filePath, e);
        }
    }
}
