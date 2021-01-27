package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input2.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);
        List<String> names = Analysis.getAllNames(lines);
        List<List<String>> happiness = Analysis.getHappiness(lines);

        List<List<String>> permutes = Analysis.permute(names.toArray(new String[0]));

        int maxHappiness = Analysis.getHighestHappiness(permutes, happiness);

        System.out.println(maxHappiness);
    }
}
