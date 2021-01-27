package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void calculateFloor1() {
        //given
        String givenResult = "(())";

        int expectedFloor = 0;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor2() {
        //given
        String givenResult = "()()";

        int expectedFloor = 0;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor3() {
        //given
        String givenResult = "(((";

        int expectedFloor = 3;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor4() {
        //given
        String givenResult = "(()(()(";

        int expectedFloor = 3;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor5() {
        //given
        String givenResult = "))(((((";

        int expectedFloor = 3;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor6() {
        //given
        String givenResult = "())";

        int expectedFloor = -1;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor7() {
        //given
        String givenResult = "))(";

        int expectedFloor = -1;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor8() {
        //given
        String givenResult = ")))";

        int expectedFloor = -3;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor9() {
        //given
        String givenResult = ")())())";

        int expectedFloor = -3;

        List<String> results = Parser.parseResult(givenResult);

        //when
        int actualFloor = Parser.calculateFloor(results);

        //then
        assertEquals(expectedFloor, actualFloor);
    }
}