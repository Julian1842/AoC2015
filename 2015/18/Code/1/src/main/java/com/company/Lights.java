package com.company;

import java.util.Arrays;
import java.util.List;

public class Lights {
    public static int[][] createInitialLightField(List<String> lines, int rowSize, int colSize, int steps) {
        int[][] lightField = new int[rowSize][colSize];

        for (int row = 0; row < lightField.length; row++) {

            for (int col = 0; col < lightField[row].length; col++) {

                if (lines.get(row).charAt(col) == '#') {
                    lightField[row][col] = 1;
                }
            }
        }


        return createNewLightField(lightField, rowSize, colSize, steps);
    }

    private static int[][] createNewLightField(int[][] lightField, int rowSize, int colSize, int steps) {
        for (int i = 0; i < steps; i++) {

            int[][] copiedLightField = new int[rowSize][colSize];

            for (int row = 0; row < lightField.length; row++) {

                for (int col = 0; col < lightField[row].length; col++) {
                    List<Integer> neighbors = getNeighbors(lightField, row, col);

                    int countLightsOn = 0;

                    for (Integer neighbor : neighbors) {
                        if (neighbor == 1) {
                            countLightsOn++;
                        }
                    }

                    if (lightField[row][col] == 1) {

                        if (countLightsOn == 2 || countLightsOn == 3) {
                            copiedLightField[row][col] = 1;
                        }

                    } else if (lightField[row][col] == 0) {

                        if (countLightsOn == 3) {
                            copiedLightField[row][col] = 1;
                        }

                    }
                }
            }

            lightField = Arrays.stream(copiedLightField).map(int[]::clone).toArray(int[][]::new);
        }

        return lightField;
    }

    private static List<Integer> getNeighbors(int[][] copiedLightField, int row, int col) {
        int rowLengthIndex = copiedLightField.length - 1;
        int colLengthIndex = copiedLightField[row].length - 1;
        
        if (row == 0 && col == 0) {
            return List.of(copiedLightField[row][col + 1], copiedLightField[row + 1][col], copiedLightField[row + 1][col + 1]);
        } else if (row == rowLengthIndex && col == colLengthIndex) {
            return List.of(copiedLightField[row][col - 1], copiedLightField[row - 1][col], copiedLightField[row - 1][col - 1]);
        } else if (row == 0 && col == colLengthIndex) {
            return List.of(copiedLightField[row][col - 1], copiedLightField[row + 1][col - 1], copiedLightField[row + 1][col]);
        } else if (row == rowLengthIndex && col == 0) {
            return List.of(copiedLightField[row][col + 1], copiedLightField[row - 1][col + 1], copiedLightField[row - 1][col]);
        } else if (row == 0) {
            return List.of(copiedLightField[row][col + 1], copiedLightField[row][col - 1], copiedLightField[row + 1][col], copiedLightField[row + 1][col - 1], copiedLightField[row + 1][col + 1]);
        } else if (row == rowLengthIndex) {
            return List.of(copiedLightField[row][col + 1], copiedLightField[row][col - 1], copiedLightField[row - 1][col], copiedLightField[row - 1][col - 1], copiedLightField[row - 1][col + 1]);
        } else if (col == 0) {
            return List.of(copiedLightField[row][col + 1], copiedLightField[row + 1][col], copiedLightField[row - 1][col], copiedLightField[row + 1][col + 1], copiedLightField[row - 1][col + 1]);
        } else if (col == colLengthIndex) {
            return List.of(copiedLightField[row][col - 1], copiedLightField[row + 1][col], copiedLightField[row - 1][col], copiedLightField[row - 1][col - 1], copiedLightField[row + 1][col - 1]);
        } else {
            return List.of(copiedLightField[row][col + 1], copiedLightField[row][col - 1], copiedLightField[row + 1][col], copiedLightField[row - 1][col], copiedLightField[row - 1][col - 1], copiedLightField[row + 1][col - 1], copiedLightField[row + 1][col + 1], copiedLightField[row - 1][col + 1]);
        }
    }
}
