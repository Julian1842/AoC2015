package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightsTest {
    @Test
    void countLights1() {
        //given
        List<String> lines = Reader.readFile("../../TestInput.txt");
        int[][] lightField = Lights.createInitialLightField(lines, 6, 6, 4);

        int expected = 4;
        int actual = 0;

        //when
        for (int y = 0; y < lightField.length; y++) {
            for (int x = 0; x < lightField[y].length; x++) {
                if (lightField[y][x] == 1) {
                    actual++;
                }
            }
        }

        //then
        assertEquals(expected, actual);
    }
}