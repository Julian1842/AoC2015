package com.company;

import java.util.List;

public class Main {
    private static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);

        int count = 0;

        for (String s : lines) {
            if (Analysis.isStringNice(s)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
