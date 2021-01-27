package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;
import java.util.Map;

public class Analysis {
    public static int countNumbers(JsonNode node, boolean ignoreRed) {
        if (node.isArray() ) {
            return countNumbersOfArray((ArrayNode) node, ignoreRed);
        } else if (node.isObject()) {
            return countNumbersOfObject((ObjectNode) node, ignoreRed);
        } else {
            return node.asInt();
        }
    }

    private static int countNumbersOfObject(ObjectNode node, boolean ignoreRed) {
        int sum = 0;

        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();

            JsonNode childNode = field.getValue();

            if (ignoreRed && childNode.asText().equals("red")) {
                return 0;
            }

            sum += countNumbers(childNode, ignoreRed);
        }

        return sum;
    }

    private static int countNumbersOfArray(ArrayNode node, boolean ignoreRed) {
        int sum = 0;
        for (Iterator<JsonNode> it = node.elements(); it.hasNext(); ) {
            JsonNode childNode = it.next();
            sum += countNumbers(childNode, ignoreRed);
        }

        return sum;
    }
}
