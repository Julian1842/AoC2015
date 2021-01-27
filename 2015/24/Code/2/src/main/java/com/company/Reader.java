package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<Integer> readFile(String path) {
        BufferedReader br;

        ArrayList<Integer> rows = new ArrayList<>();

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
