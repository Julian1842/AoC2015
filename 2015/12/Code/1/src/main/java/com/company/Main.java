package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) throws JsonProcessingException {
        List<String> lines = Reader.readFile(PATH);

        String json = lines.get(0);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        boolean ignoreRed = false;
        int sum = Analysis.countNumbers(rootNode, ignoreRed);

        System.out.println(String.format("The total sum is %d", sum));
    }
}
