package com.company;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Ring>> ringCombinations = new ArrayList<>();

    public static void permute(List<Ring> rings) {
        Ring[] ringsArray = new Ring[rings.size()];
        ringsArray = rings.toArray(ringsArray);

        printCombination(ringsArray, ringsArray.length, 2);
    }

    public static void combinationUtil(Ring arr[], Ring data[], int start, int end, int index, int r) {
        if (index == r) {
            List<Ring> currentCombination = new ArrayList<>();

            for (int j=0; j<r; j++) {
                currentCombination.add(data[j]);
            }

            ringCombinations.add(currentCombination);

            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    public static void printCombination(Ring arr[], int n, int r) {
        Ring data[]=new Ring[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }
}
