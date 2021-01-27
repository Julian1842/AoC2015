package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<Integer> buckets = Reader.readFile(PATH);

        Integer[] arr = new Integer[buckets.size()];
        arr = buckets.toArray(arr);

        Analysis analysis = new Analysis();

        for (int r = 1; r <= buckets.size(); r++) {
            int n = arr.length;
            analysis.printCombination(arr, n, r);
        }

        System.out.println(analysis.getAmountOfCombinations(150));
    }
}
