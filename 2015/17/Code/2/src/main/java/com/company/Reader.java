package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<Integer> readFile(String path) {
        BufferedReader br;

        List<Integer> rows = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(path));

            String line = br.readLine();

            while (line != null) {
                rows.add(Integer.parseInt(line));

                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
