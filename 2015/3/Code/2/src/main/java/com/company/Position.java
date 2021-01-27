package com.company;

import java.util.ArrayList;
import java.util.List;

public class Position {
    public static int calculatePresents(List<String> values) {
        int santaX = 0;
        int santaY = 0;

        int roboX = 0;
        int roboY = 0;

        List<List<Integer>> houses = new ArrayList<>();

        houses.add(List.of(santaX, santaY));

        updatePositions(values, santaX, santaY, roboX, roboY, houses);

        return houses.size();
    }

    private static void updatePositions(List<String> values, int santaX, int santaY, int robotX, int robotY, List<List<Integer>> houses) {
        for (int i = 0; i < values.size(); i++) {

            if ((i + 1) % 2 != 0) {
                switch (values.get(i)) {
                    case ">":
                        santaX++;
                        break;
                    case "<":
                        santaX--;
                        break;
                    case "^":
                        santaY++;
                        break;
                    case "v":
                        santaY--;
                        break;
                    default:
                        System.out.println("Error");
                }

                List<Integer> newPositionSanta = List.of(santaX, santaY);
                doesHouseExistOrPut(houses, newPositionSanta);
            } else if ((i + 1) % 2 == 0) {
                switch (values.get(i)) {
                    case ">":
                        robotX++;
                        break;
                    case "<":
                        robotX--;
                        break;
                    case "^":
                        robotY++;
                        break;
                    case "v":
                        robotY--;
                        break;
                    default:
                        System.out.println("Error");
                }

                List<Integer> newPositionRobot = List.of(robotX, robotY);
                doesHouseExistOrPut(houses, newPositionRobot);
            }
        }
    }

    private static void doesHouseExistOrPut(List<List<Integer>> houses, List<Integer> position) {
        if (!houses.contains(position)) {
            houses.add(position);
        }
    }
}
