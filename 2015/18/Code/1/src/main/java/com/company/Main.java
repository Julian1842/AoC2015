package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);
        int[][] lightField = Lights.createInitialLightField(lines, 100, 100, 100);

        int countLightsOn = 0;

        for (int[] ints : lightField) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    countLightsOn++;
                }
            }
        }

        System.out.println(countLightsOn);
    }
}
