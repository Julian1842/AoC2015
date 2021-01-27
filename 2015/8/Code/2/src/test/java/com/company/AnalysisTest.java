package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {

    @Test
    void calculateChars1() {
        //given
        Analysis analysis = new Analysis();

        String input = "\"\"";

        List<String> lines = List.of(input);

        //when
        analysis.calculateChars(lines);

        //then
        assertEquals(2, analysis.getCharsInCode());
        assertEquals(6, analysis.getCharsInString());
    }

    @Test
    void calculateChars2() {
        //given
        Analysis analysis = new Analysis();

        String input = "\"abc\"";

        List<String> lines = List.of(input);

        //when
        analysis.calculateChars(lines);

        //then
        assertEquals(5, analysis.getCharsInCode());
        assertEquals(9, analysis.getCharsInString());
    }

    @Test
    void calculateChars3() {
        //given
        Analysis analysis = new Analysis();

        String input = "\"aaa\\\"aaa\"";

        List<String> lines = List.of(input);

        //when
        analysis.calculateChars(lines);

        //then
        assertEquals(10, analysis.getCharsInCode());
        assertEquals(16, analysis.getCharsInString());
    }

    @Test
    void calculateChars4() {
        //given
        Analysis analysis = new Analysis();

        String input = "\"\\x27\"";

        List<String> lines = List.of(input);

        //when
        analysis.calculateChars(lines);

        //then
        assertEquals(6, analysis.getCharsInCode());
        assertEquals(11, analysis.getCharsInString());
    }
}