package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void isStringNice1() {
        //given
        String line = "ugknbfddgicrmopn";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertTrue(actual);
    }

    @Test
    void isStringNice2() {
        //given
        String line = "aaa";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertTrue(actual);
    }

    @Test
    void isStringNice3() {
        //given
        String line = "jchzalrnumimnmhp";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertFalse(actual);
    }

    @Test
    void isStringNice4() {
        //given
        String line = "haegwjzuvuyypxyu";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertFalse(actual);
    }

    @Test
    void isStringNice5() {
        //given
        String line = "dvszwmarrgswjxmb";

        //when
        boolean actual = Analysis.isStringNice(line);

        //then
        assertFalse(actual);
    }
}