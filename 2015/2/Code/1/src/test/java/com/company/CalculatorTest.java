package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calculateTotalWrappingPaper1() {
        //given
        List<String> values = List.of("2", "3", "4");
        List<List<String>> lineValues = List.of(values);

        int expected = 58;

        //when
        int actual = Calculator.calculateTotalWrappingPaper(lineValues);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalWrappingPaper2() {
        //given
        List<String> values = List.of("1", "1", "10");
        List<List<String>> lineValues = List.of(values);

        int expected = 43;

        //when
        int actual = Calculator.calculateTotalWrappingPaper(lineValues);

        //then
        assertEquals(expected, actual);
    }
}