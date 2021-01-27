package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lights {
    int[][] lightField = new int[1000][1000];

    public void changeLights(List<String> lines) {
        for (String line : lines) {
            String currentCommand = getCommand(line);

            List<Integer> numbers = getNumbersFrom(line);

            assert currentCommand != null;

            runLightsCommand(numbers, currentCommand);
        }
    }

    private void runLightsCommand(List<Integer> numbers, String command) {
        int x1 = numbers.get(0);
        int y1 = numbers.get(1);
        int x2 = numbers.get(2);
        int y2 = numbers.get(3);


        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (command.equals("toggle")) {
                    lightField[x][y] += 2;
                } else if (command.equals("turnOff")) {
                    if (lightField[x][y] > 0) {
                        lightField[x][y] -= 1;
                    }
                } else if (command.equals("turnOn")) {
                    lightField[x][y] += 1;
                }
            }
        }
    }

    private List<Integer> getNumbersFrom(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);

        List<Integer> numbers = new ArrayList<>();

        while(m.find()) {
            numbers.add(Integer.valueOf(m.group()));
        }

        return numbers;
    }

    private String getCommand(String line) {
        if (line.contains("toggle")) {
            return "toggle";
        } else if (line.contains("turn off")) {
            return "turnOff";
        } else if (line.contains("turn on")) {
            return "turnOn";
        }

        return null;
    }

    public int getTotalBrightness() {
        int count = 0;

        for (int x = 0; x < lightField.length; x++) {
            for (int y = 0; y < lightField[x].length; y++) {
                count += lightField[x][y];
            }
        }

        return count;
    }
}
