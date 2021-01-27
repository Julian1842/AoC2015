package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static List<String> getAllNames(List<String> lines) {
        List<String> names = new ArrayList<>();

        for (String line : lines) {
            String[] parts = splitLine(line);

            String name1 = removeLastCharFrom(parts[0]);
            String name2 = removeLastCharFrom(parts[10]);

            if (!names.contains(name1)) {
                names.add(name1);
            }

            if (!names.contains(name2)) {
                names.add(name2);
            }
        }

        return names;
    }

    public static int getHighestHappiness(List<List<String>> permutes, List<List<String>> happiness) {
        int totalHappiness = Integer.MIN_VALUE;

        for (int i = 0; i < permutes.size(); i++) {

            int currentHappiness = 0;

            for (int j = 0; j < permutes.get(i).size(); j++) {
                List<String> currentPermutes = permutes.get(i);

                String currentPerson = permutes.get(i).get(j);

                String previousPerson = getPreviousPerson(currentPermutes, j);
                String nextPerson = getNextPerson(currentPermutes, j);

                int leftHappiness = calculateHappinessBetween(currentPerson, previousPerson, happiness);
                int rightHappiness = calculateHappinessBetween(currentPerson, nextPerson, happiness);

                currentHappiness += (leftHappiness + rightHappiness);
            }

            if (currentHappiness > totalHappiness) {
                totalHappiness = currentHappiness;
            }
        }

        return totalHappiness;
    }

    private static int calculateHappinessBetween(String currentPerson, String otherPerson, List<List<String>> happiness) {
        for (int i = 0; i < happiness.size(); i++) {
            List<String> currentRelation = happiness.get(i);

            if (currentRelation.get(0).equals(currentPerson) && currentRelation.get(1).equals(otherPerson)) {
                return Integer.parseInt(currentRelation.get(2));
            }
        }

        return Integer.MIN_VALUE;
    }

    private static String getPreviousPerson(List<String> currentPermutes, int j) {
        String previousPerson;

        if (j == 0) {
            previousPerson = currentPermutes.get(currentPermutes.size() - 1);
        } else {
            previousPerson = currentPermutes.get(j - 1);
        }

        return previousPerson;
    }

    private static String getNextPerson(List<String> currentPermutes, int j) {
        String nextPerson;

        if (j == currentPermutes.size() - 1) {
            nextPerson = currentPermutes.get(0);
        } else {
            nextPerson = currentPermutes.get(j + 1);
        }

        return nextPerson;
    }

    public static List<List<String>> getHappiness(List<String> lines) {
        List<List<String>> happines = new ArrayList<>();

        for (String line : lines) {
            List<String> relation = new ArrayList<>();

            String[] parts = splitLine(line);

            String name1 = removeLastCharFrom(parts[0]);
            String name2 = removeLastCharFrom(parts[10]);
            String value = "";

            if (parts[2].equals("gain")) {
                value = parts[3];
            }

            if (parts[2].equals("lose")) {
                value = String.format("-%s", parts[3]);
            }

            relation.add(name1);
            relation.add(name2);
            relation.add(value);

            happines.add(relation);
        }

        return happines;
    }

    private static String[] splitLine(String line) {
        return line.split(" ");
    }

    private static String removeLastCharFrom(String part) {
        if (part.charAt(part.length() - 1) == '.') {
            return part.substring(0, part.length() - 1);
        }

        return part;
    }


    public static List<List<String>> permute(String[] elements) {
        List<List<String>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), elements);
        return list;
    }

    private static void permuteHelper(List<List<String>> list, List<String> resultList, String[] arr){
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (resultList.contains(arr[i])) {
                    continue;
                }

                resultList.add(arr[i]);
                permuteHelper(list, resultList, arr);
                resultList.remove(resultList.size() - 1);
            }
        }
    }
}
