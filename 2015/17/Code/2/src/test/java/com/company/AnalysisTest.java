package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void getMinCombinations1() {
        //given
        List<Integer> buckets = List.of(20, 15, 10, 5, 5);
        Integer[] arr = new Integer[buckets.size()];
        arr = buckets.toArray(arr);

        Analysis analysis = new Analysis();

        for (int r = 1; r <= buckets.size(); r++) {
            int n = arr.length;
            analysis.printCombination(arr, n, r);
        }

        List<List<Integer>> workingCombinations = analysis.getCombinations(25);

        int expected = 3;

        //when
        int actual = analysis.getMinCombinations(workingCombinations);

        //then
        assertEquals(expected, actual);
    }
}