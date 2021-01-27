package com.company;

import java.util.List;

public class Calculator {
    public static int calculateTotalWrappingPaper(List<List<String>> lineValues) {
        int total = 0;

        for (List<String> list : lineValues) {
            int length = Integer.parseInt(list.get(0));
            int width = Integer.parseInt(list.get(1));
            int height = Integer.parseInt(list.get(2));

            total += calculate(length, width, height);
        }

        return total;
    }

    private static int calculate(int length, int width, int height) {
        int total = 0;

        int calculation1 = length * width;
        int calculation2 = length * height;
        int calculation3 = width * height;

        int lowest = findLowest(List.of(calculation1, calculation2, calculation3));

        total += 2 * calculation1;
        total += 2 * calculation2;
        total += 2 * calculation3;
        total += lowest;

        return total;
    }

    private static int findLowest(List<Integer> calculations) {
        int smallest = Integer.MAX_VALUE;

        for (Integer i : calculations) {
            if (i < smallest) {
                smallest = i;
            }
        }

        return smallest;
    }
}
