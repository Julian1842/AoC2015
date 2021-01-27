package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);

        List<List<String>> parts = Analysis.splitLine(lines);
        List<String> locations = Analysis.getAllLocations(parts);

        String[] elements = convertListToArray(locations);

        List<List<String>> permute = Analysis.permute(elements);

        System.out.println(Analysis.getShortestWay(permute, parts));
    }

    public static String[] convertListToArray(List<String> list) {
        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }
}
