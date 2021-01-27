package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static List<List<String>> readFile(String path) {
        BufferedReader br;

        List<List<String>> rows = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(path));

            String line = br.readLine();

            while (line != null) {
                rows.add(splitLine(line));

                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

    private static List<String> splitLine(String line) {

        String[] lineArray = line.split("x");

        return new ArrayList<>(Arrays.asList(lineArray));
    }
}
