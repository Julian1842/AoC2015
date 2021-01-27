package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void calculatePresents1() {
        //given


        //when
        int[] houses = calculatePresentsDummy();

        //then
        assertEquals(10, houses[1]);
        assertEquals(30, houses[2]);
        assertEquals(40, houses[3]);
        assertEquals(70, houses[4]);
        assertEquals(60, houses[5]);
        assertEquals(120, houses[6]);
        assertEquals(80, houses[7]);
        assertEquals(150, houses[8]);
        assertEquals(130, houses[9]);
    }


    private int[] calculatePresentsDummy() {
        int size = 1000000;

        int[] houses = new int[size];

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j += i) {
                houses[j] += i * 10;
            }
        }

        return houses;
    }
}