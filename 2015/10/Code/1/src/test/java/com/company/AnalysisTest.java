package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void calculate1() {
        //given
        String input = "1";

        String expected = "11";

        //when
        String actual = Analysis.calculate(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void calculate2() {
        //given
        String input = "11";

        String expected = "21";

        //when
        String actual = Analysis.calculate(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void calculate3() {
        //given
        String input = "21";

        String expected = "1211";

        //when
        String actual = Analysis.calculate(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void calculate4() {
        //given
        String input = "1211";

        String expected = "111221";

        //when
        String actual = Analysis.calculate(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void calculate5() {
        //given
        String input = "111221";

        String expected = "312211";

        //when
        String actual = Analysis.calculate(input);

        //then
        assertEquals(expected, actual);
    }
}