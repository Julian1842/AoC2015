package com.company;

import java.util.ArrayList;
import java.util.List;

public class Position {
    public static int calculatePresents(List<String> values) {
        int x = 0;
        int y = 0;

        List<List<Integer>> houses = new ArrayList<>();

        houses.add(List.of(x, y));

        for (String s : values) {
            switch (s) {
                case ">":
                    x++;
                    break;
                case "<":
                    x--;
                    break;
                case "^":
                    y++;
                    break;
                case "v":
                    y--;
                    break;
                default:
                    System.out.println("Error");
            }

            List<Integer> newPosition = List.of(x, y);

            doesHouseExistOrPut(houses, newPosition);
        }

        return houses.size();
    }

    private static void doesHouseExistOrPut(List<List<Integer>> houses, List<Integer> position) {
        if (!houses.contains(position)) {
            houses.add(position);
        }
    }
}
