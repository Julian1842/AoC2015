package com.company;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> valueCombinations = new ArrayList<>();

    public static void permute(List<Integer> values) {
        Integer[] ringsArray = new Integer[values.size()];
        ringsArray = values.toArray(ringsArray);

        printCombination(ringsArray, ringsArray.length, ringsArray.length);
    }

    public static void combinationUtil(Integer arr[], Integer data[], int start, int end, int index, int r) {
        if (index == r) {
            List<Integer> currentCombination = new ArrayList<>();

            for (int j=0; j<r; j++) {
                currentCombination.add(data[j]);
            }

            valueCombinations.add(currentCombination);

            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    public static void printCombination(Integer arr[], int n, int r) {
        Integer data[]=new Integer[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }
}
