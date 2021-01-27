package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);

        int lowestHouse = Analysis.calculatePresents(lines);
        System.out.println(lowestHouse);
    }
}
