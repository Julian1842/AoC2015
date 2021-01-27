package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightsTest {
    @Test
    void countLights1() {
        //given
        List<String> lines = Reader.readFile("../../TestInput.txt");
        int[][] lightField = Lights.createInitialLightField(lines, 6, 6, 5);

        int expected = 17;
        int actual = 0;

        //when
        for (int[] ints : lightField) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    actual++;
                }
            }
        }

        //then
        assertEquals(expected, actual);
    }
}