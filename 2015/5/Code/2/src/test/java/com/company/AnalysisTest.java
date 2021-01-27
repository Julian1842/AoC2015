package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void isStringNice1() {
        //given
        String line = "qjhvhtzxzqqjkmpb";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertTrue(actual);
    }

    @Test
    void isStringNice2() {
        //given
        String line = "xxyxx";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertTrue(actual);
    }

    @Test
    void isStringNice3() {
        //given
        String line = "uurcxstgmygtbstg";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertFalse(actual);
    }

    @Test
    void isStringNice4() {
        //given
        String line = "ieodomkazucvgmuy";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertFalse(actual);
    }
}