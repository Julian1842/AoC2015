package com.company;

import java.util.List;

public class Calculator {
    public static int calculateTotalWrappingPaper(List<List<String>> lineValues) {
        int totalWrappingPaper = 0;

        for (List<String> list : lineValues) {
            int length = Integer.parseInt(list.get(0));
            int width = Integer.parseInt(list.get(1));
            int height = Integer.parseInt(list.get(2));

            totalWrappingPaper += calculateWrappingPaper(length, width, height);
        }

        return totalWrappingPaper;
    }

    private static int calculateWrappingPaper(int length, int width, int height) {
        int total = 0;

        int calculation1 = length * width;
        int calculation2 = length * height;
        int calculation3 = width * height;

        int lowest = findLowest(calculation1, calculation2, calculation3);

        total += 2 * calculation1;
        total += 2 * calculation2;
        total += 2 * calculation3;
        total += lowest;

        return total;
    }

    private static int findLowest(int calculation1, int calculation2, int calculation3) {
        int smallest = calculation1;

        if (smallest > calculation2) {
            smallest = calculation2;
        }

        if (smallest > calculation3) {
            smallest = calculation3;
        }

        return smallest;
    }

    public static int calculateTotalRibbon(List<List<String>> lineValues) {
        int totalRibbon = 0;

        for (List<String> list : lineValues) {
            int length = Integer.parseInt(list.get(0));
            int width = Integer.parseInt(list.get(1));
            int height = Integer.parseInt(list.get(2));

            totalRibbon += calculateRibbon(length, width, height);
        }

        return totalRibbon;
    }

    private static int calculateRibbon(int length, int width, int height) {
        int total = 0;

        int calculation1 = length + length + width + width;
        int calculation2 = length + length + height + height;
        int calculation3 = width + width + height + height;

        total += length * width * height;
        total += findLowest(calculation1, calculation2, calculation3);

        return total;
    }
}
