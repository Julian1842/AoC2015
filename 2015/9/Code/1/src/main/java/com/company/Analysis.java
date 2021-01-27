package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static List<List<String>> splitLine(List<String> lines) {
        List<List<String>> lineParts = new ArrayList<>();

        for (String line : lines) {
            List<String> parts = new ArrayList<>();

            String[] split = line.split("to");

            parts.add(split[0].trim());

            String[] secondSplit = split[1].split("=");

            parts.add(secondSplit[0].trim());
            parts.add(secondSplit[1].trim());

            lineParts.add(parts);
        }

        return lineParts;
    }

    public static List<String> getAllLocations(List<List<String>> parts) {
        List<String> locations = new ArrayList<>();

        for (int i = 0; i < parts.size(); i++) {
            for (int j = 0; j < parts.get(i).size() - 1; j++) {
                String currentLocation = parts.get(i).get(j);

                if (!locations.contains(currentLocation)) {
                    locations.add(currentLocation);
                }
            }
        }

        return locations;
    }

    public static List<List<String>> permute(String[] elements) {
        List<List<String>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), elements);
        return list;
    }

    private static void permuteHelper(List<List<String>> list, List<String> resultList, String[] arr){
        if (resultList.size() == arr.length){
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

    public static int getShortestWay(List<List<String>> permute, List<List<String>> parts) {
        int currentMinimum = Integer.MAX_VALUE;

        for (int i = 0; i < permute.size(); i++) {

            int totalDistance = 0;

            for (int j = 0; j < permute.get(i).size() - 1; j++) {

                List<String> currentPermute = permute.get(i);

                String currentPlace = currentPermute.get(j);
                String nextPlace = currentPermute.get(j + 1);

                for (int x = 0; x < parts.size(); x++) {
                    String originPlace = parts.get(x).get(0);
                    String destinationPlace = parts.get(x).get(1);
                    int distance = Integer.parseInt(parts.get(x).get(2));

                    if ((originPlace.equals(currentPlace) && destinationPlace.equals(nextPlace)) || (originPlace.equals(nextPlace) && destinationPlace.equals(currentPlace))) {
                        totalDistance += distance;
                    }
                }


            }

            if (totalDistance < currentMinimum) {
                currentMinimum = totalDistance;
            }
        }

        return currentMinimum;
    }
}

























