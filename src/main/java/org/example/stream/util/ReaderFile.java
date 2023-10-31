package org.example.stream.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {

    public static String getText(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb = sb.append(line).append(" ");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

