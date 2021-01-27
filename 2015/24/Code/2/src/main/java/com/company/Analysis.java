package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    private List<List<Integer>> possibleFirstParts = new ArrayList<>();

    public int getNeededSum(List<Integer> values) {
        int totalSum = 0;

        for (Integer i : values) {
            totalSum += i;
        }

        return totalSum / 4;
    }

    private void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x: partial) s += x;
        if (s == target)
            possibleFirstParts.add(partial);
        if (s >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }

    public List<List<Integer>> sum_up(ArrayList<Integer> numbers, int target) {
        // https://stackoverflow.com/questions/4632322/finding-all-possible-combinations-of-numbers-to-reach-a-given-sum
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
        return possibleFirstParts;
    }


    public List<List<Integer>> getSmallestPossibleSize(List<List<Integer>> possibleFirstParts) {
        List<List<Integer>> smallestPossibleSizes = new ArrayList<>();

        int currentSmallest = Integer.MAX_VALUE;

        for (List<Integer> list : possibleFirstParts) {
            if (list.size() < currentSmallest) {
                currentSmallest = list.size();
            }
        }

        for (List<Integer> list : possibleFirstParts) {
            if (list.size() == currentSmallest) {
                smallestPossibleSizes.add(list);
            }
        }

        return smallestPossibleSizes;
    }

    public long getSmallesQE(List<List<Integer>> smallestPossibleSizes) {
        long currentSmallest = Long.MAX_VALUE;

        for (List<Integer> list : smallestPossibleSizes) {
            long currentQE = 1L;

            for (Integer i : list) {
                currentQE *= (long) i;
            }

            if (currentQE < currentSmallest) {
                currentSmallest = currentQE;
            }
        }

        return currentSmallest;
    }
}
