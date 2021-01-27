package com.company;

import java.util.Arrays;
import java.util.List;

public class Lights {
    public static int[][] createInitialLightField(List<String> lines, int rowSize, int colSize, int steps) {
        int[][] lightField = new int[rowSize][colSize];

        int rowLengthIndex = lightField.length - 1;
        int colLengthIndex = lightField[rowLengthIndex].length - 1;

        lightField[0][0] = 1;
        lightField[rowLengthIndex][colLengthIndex] = 1;
        lightField[rowLengthIndex][0] = 1;
        lightField[0][colLengthIndex] = 1;

        for (int row = 0; row < lightField.length; row++) {

            for (int col = 0; col < lightField[row].length; col++) {

                if ((row == 0 && col == 0) || (row == rowLengthIndex && col == colLengthIndex) || (row == 0 && col == colLengthIndex) || (row == rowLengthIndex && col == 0)) {
                    lightField[row][col] = 1;
                } else {
                    if (lines.get(row).charAt(col) == '#') {
                        lightField[row][col] = 1;
                    }
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
                    int rowLengthIndex = rowSize - 1;
                    int colLengthIndex = colSize - 1;

                    if ((row == 0 && col == 0) || (row == rowLengthIndex && col == colLengthIndex) || (row == 0 && col == colLengthIndex) || (row == rowLengthIndex && col == 0)) {
                        copiedLightField[row][col] = 1;
                    } else {
                        List<Integer> neighbors = getNeighbors(lightField, row, col);

                        int countLightsOn = 0;

                        for (int j = 0; j < neighbors.size(); j++) {
                            if (neighbors.get(j) == 1) {
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
            }

            lightField = Arrays.stream(copiedLightField).map(int[]::clone).toArray(int[][]::new);;
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
