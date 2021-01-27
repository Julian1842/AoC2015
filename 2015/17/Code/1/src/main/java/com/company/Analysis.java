package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analysis {
    private final List<List<Integer>> combinations = new ArrayList<>();

    public void combinationUtil(Integer[] arr, Integer[] data, Integer start, Integer end, Integer index, Integer r) {
        if (index.equals(r)) {
            List<Integer> currentCombination = new ArrayList<>(Arrays.asList(data).subList(0, r));
            combinations.add(currentCombination);
            return;
        }

        for (Integer i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    public void printCombination(Integer[] arr, Integer n, Integer r) {
        Integer[] data = new Integer[r];
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    public int getAmountOfCombinations(int sumNeeded) {
        int count = 0;
        for (List<Integer> combination : combinations) {
            int currentCount = 0;
            for (Integer integer : combination) {
                currentCount += integer;
            }

            if (currentCount == sumNeeded) {
                count++;
            }
        }

        return count;
    }
}
