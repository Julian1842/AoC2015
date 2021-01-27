package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {

        List<String> lines = Reader.readFile(PATH);

        Analysis analysis = new Analysis();
        analysis.calculateChars(lines);

        System.out.println(analysis.getSolution());

    }
}
