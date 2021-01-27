package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        Analysis analysis = new Analysis();

        ArrayList<Integer> values = Reader.readFile(PATH);
        int neededSum = analysis.getNeededSum(values);

        List<List<Integer>> possibleFirstParts = analysis.sum_up(values, neededSum);
        List<List<Integer>> smallestSizes = analysis.getSmallestPossibleSize(possibleFirstParts);
        long smallestQE = analysis.getSmallesQE(smallestSizes);

        System.out.println(smallestQE);
    }
}
