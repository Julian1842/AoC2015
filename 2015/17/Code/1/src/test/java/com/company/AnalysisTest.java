package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {
    @Test
    void getCombinations1() {
        //given
        List<Integer> buckets = List.of(20, 15, 10, 5, 5);
        Integer[] arr = new Integer[buckets.size()];
        arr = buckets.toArray(arr);

        Analysis analysis = new Analysis();

        for (int r = 1; r <= buckets.size(); r++) {
            int n = arr.length;
            analysis.printCombination(arr, n, r);
        }

        int expected = 4;

        //when
        int actual = analysis.getAmountOfCombinations(25);

        //then
        assertEquals(expected, actual);
    }
}