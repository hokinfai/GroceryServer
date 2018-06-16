package com.sainsbury.grocery.core;

import static com.google.common.base.Charsets.UTF_8;

import java.io.IOException;

import com.google.common.io.Resources;

public class FileReader {

    public static String readFileFrom(String filePath) throws IOException {
        return Resources.toString(Resources.getResource(filePath), UTF_8);
    }
}
