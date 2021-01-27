package com.company;

import java.util.List;

public class Main {
    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<List<String>> values = Reader.readFile(PATH);

        int totalWrappingPaper = Calculator.calculateTotalWrappingPaper(values);

        System.out.println(String.format("Total needed wrapping paper: %s", totalWrappingPaper));

        int totalRibbon = Calculator.calculateTotalRibbon(values);

        System.out.println(String.format("Total needed ribbon: %s", totalRibbon));

    }
}
