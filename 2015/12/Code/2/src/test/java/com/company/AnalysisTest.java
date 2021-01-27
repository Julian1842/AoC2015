package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void countNumbers1() throws JsonProcessingException {
        //given
        String json = "[1,2,3]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 6;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers2() throws JsonProcessingException {
        //given
        String json = "{\"a\":2,\"b\":4}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 6;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers3() throws JsonProcessingException {
        //given
        String json = "[[[3]]]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 3;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers4() throws JsonProcessingException {
        //given
        String json = "{\"a\":{\"b\":4},\"c\":-1}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 3;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers5() throws JsonProcessingException {
        //given
        String json = "{\"a\":[-1,1]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 0;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers6() throws JsonProcessingException {
        //given
        String json = "[-1,{\"a\":1}]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 0;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers7() throws JsonProcessingException {
        //given
        String json = "[]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 0;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers8() throws JsonProcessingException {
        //given
        String json = "{}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;

        int expected = 0;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    // Part 2

    @Test
    void countNumbers9() throws JsonProcessingException {
        //given
        String json = "[1,2,3]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = true;

        int expected = 6;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers10() throws JsonProcessingException {
        //given
        String json = "[1,{\"c\":\"red\",\"b\":2},3]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = true;

        int expected = 4;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers11() throws JsonProcessingException {
        //given
        String json = "{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = true;

        int expected = 0;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void countNumbers12() throws JsonProcessingException {
        //given
        String json = "[1,\"red\",5]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = true;

        int expected = 6;

        //when
        int actual = Analysis.countNumbers(rootNode, ignoreRed);

        //then
        assertEquals(expected, actual);
    }
}