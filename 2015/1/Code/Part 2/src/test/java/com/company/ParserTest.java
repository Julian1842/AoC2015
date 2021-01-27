package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    //Part 2

    @Test
    void calculateCharacterToFloor1() {
        //given
        String givenResult = ")";

        int expectedCharacter = 1;

        List<String> results = Parser.parseResult(givenResult);

        //when
        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        int actualCharacter = 0;

        for (Map.Entry<Integer, Integer> s: characterToFloor.entrySet()) {
            if (s.getValue() == -1) {
                actualCharacter = s.getKey();

                break;
            }
        }

        //then
        assertEquals(expectedCharacter, actualCharacter);
    }

    @Test
    void calculateCharacterToFloor2() {
        //given
        String givenResult = "()())";

        int expectedCharacter = 5;

        List<String> results = Parser.parseResult(givenResult);

        //when
        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        int actualCharacter = 0;

        for (Map.Entry<Integer, Integer> s: characterToFloor.entrySet()) {
            if (s.getValue() == -1) {
                actualCharacter = s.getKey();

                break;
            }
        }

        //then
        assertEquals(expectedCharacter, actualCharacter);
    }

    // Part 1

    @Test
    void calculateFloor1() {
        //given
        String givenResult = "(())";

        int expectedFloor = 0;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor2() {
        //given
        String givenResult = "()()";

        int expectedFloor = 0;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor3() {
        //given
        String givenResult = "(((";

        int expectedFloor = 3;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor4() {
        //given
        String givenResult = "(()(()(";

        int expectedFloor = 3;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor5() {
        //given
        String givenResult = "))(((((";

        int expectedFloor = 3;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor6() {
        //given
        String givenResult = "())";

        int expectedFloor = -1;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor7() {
        //given
        String givenResult = "))(";

        int expectedFloor = -1;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor8() {
        //given
        String givenResult = ")))";

        int expectedFloor = -3;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void calculateFloor9() {
        //given
        String givenResult = ")())())";

        int expectedFloor = -3;

        List<String> results = Parser.parseResult(givenResult);

        TreeMap<Integer, Integer> characterToFloor = Parser.calculateCharacterToFloor(results);

        //when
        int actualFloor = Parser.getFinalFloor(characterToFloor);

        //then
        assertEquals(expectedFloor, actualFloor);
    }
}