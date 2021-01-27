package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void calculatePresents1() {
        //given
        String line = ">";

        List<String> values = Arrays.asList(line.split(""));

        int expectedHouses = 2;

        //when
        int actualHouses = Position.calculatePresents(values);

        //then
        assertEquals(expectedHouses, actualHouses);
    }

    @Test
    void calculatePresents2() {
        //given
        String line = "^>v<";

        List<String> values = Arrays.asList(line.split(""));

        int expectedHouses = 4;

        //when
        int actualHouses = Position.calculatePresents(values);

        //then
        assertEquals(expectedHouses, actualHouses);
    }

    @Test
    void calculatePresents3() {
        //given
        String line = "^v^v^v^v^v";

        List<String> values = Arrays.asList(line.split(""));

        int expectedHouses = 2;

        //when
        int actualHouses = Position.calculatePresents(values);

        //then
        assertEquals(expectedHouses, actualHouses);
    }
}