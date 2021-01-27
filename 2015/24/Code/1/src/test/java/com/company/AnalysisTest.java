package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void getSmallestQE() {
        //given
        Analysis analysis = new Analysis();

        ArrayList<Integer> values = Reader.readFile("../../TestInput.txt");
        int neededSum = analysis.getNeededSum(values);

        List<List<Integer>> possibleFirstParts = analysis.sum_up(values, neededSum);
        List<List<Integer>> smallestSizes = analysis.getSmallestPossibleSize(possibleFirstParts);

        long expected = 99;

        //when
        long actual = analysis.getSmallesQE(smallestSizes);

        //then
        assertEquals(expected, actual);
    }
}