package com.company;

import java.util.List;

public class Analysis {
    public static int calculatePresents(List<String> lines) {
        int input = Integer.parseInt(lines.get(0));
        int size = 1000000;

        int[] houses = new int[size];

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j += i) {
                houses[j] += i * 10;
            }
        }

        return getLowestHouse(houses, input);
    }

    private static int getLowestHouse(int[] houses, int input) {
        int lowestHouse = Integer.MAX_VALUE;

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] >= input) {
                lowestHouse = i;
                break;
            }
        }

        return lowestHouse;
    }
}
