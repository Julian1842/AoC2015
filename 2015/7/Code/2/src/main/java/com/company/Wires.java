package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wires {
    private Map<String, Integer> wires = new HashMap<>();

    public int getWiresSignalsFrom(List<String> lines) {
        wires.put("b", 3176);

        while (true) {
            for (String line : lines) {

                String[] testSplit = line.split(" -> ");

                if (testSplit[1].equals("b")) {
                    continue;
                }

                String[] s = line.split(" ");

                if (s.length == 3) {
                    if (Character.isDigit(s[0].charAt(0))) {
                        wires.put(s[2], Integer.parseInt(s[0]));
                    } else if (wires.containsKey(s[0])) {
                        wires.put(s[2], wires.get(s[0]));
                    }
                } else if (s.length == 4) {
                    if (wires.containsKey(s[1])) {
                        wires.put(s[3], ~(wires.get(s[1])));
                    }
                } else if (s[1].equals("LSHIFT")) {
                    int shiftBy = Integer.parseInt(s[2]);

                    if (wires.containsKey(s[0])) {
                        wires.put(s[4], wires.get(s[0]) << shiftBy);
                    }
                } else if (s[1].equals("RSHIFT")) {
                    int shiftBy = Integer.parseInt(s[2]);

                    if (wires.containsKey(s[0])) {
                        wires.put(s[4], wires.get(s[0]) >> shiftBy);
                    }
                } else {
                    int value1 = Integer.MIN_VALUE;

                    if (Character.isDigit(s[0].charAt(0))) {
                        value1 = Integer.parseInt(s[0]);
                    }


                    if (s[1].equals("AND") && (wires.containsKey(s[0]) || value1 != Integer.MIN_VALUE) && wires.containsKey(s[2])) {
                        wires.put(s[4], (value1 == Integer.MIN_VALUE ? wires.get(s[0]) : value1) & wires.get(s[2]));
                    } else if (s[1].equals("OR") && (wires.containsKey(s[0]) || value1 != Integer.MIN_VALUE) && wires.containsKey(s[2])) {
                        wires.put(s[4], (value1 == Integer.MIN_VALUE ? wires.get(s[0]) : value1) | wires.get(s[2]));
                    }
                }

                if (wires.containsKey("a")) {
                    return wires.get("a");
                }
            }
        }


    }

}
