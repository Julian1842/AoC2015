package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Analysis {
    public static List<Sue> createSues(List<String> lines) {
        List<Sue> sues = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(" ");

            String parameter1 = split[0];
            Integer value1 = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
            String parameter2 = split[2].substring(0, split[2].length() - 1);
            Integer value2 = Integer.parseInt(split[3].substring(0, split[3].length() - 1));
            String parameter3 = split[4].substring(0, split[4].length() - 1);
            Integer value3 = Integer.parseInt(split[5].substring(0, split[5].length() - 1));
            String parameter4 = split[6].substring(0, split[6].length() - 1);
            Integer value4 = Integer.parseInt(split[7]);

            Map<BiConsumer<Sue, Integer>, Integer> setUp = createSetUp(List.of(parameter1, parameter2, parameter3, parameter4), List.of(value1, value2, value3, value4));

            sues.add(createSue(setUp));
        }

        return sues;
    }

    private static Sue createSue(Map<BiConsumer<Sue, Integer>, Integer> setUp) {
        Sue sue = new Sue();

        for (Map.Entry<BiConsumer<Sue, Integer>, Integer> entry : setUp.entrySet()) {
            Integer value = entry.getValue();
            BiConsumer<Sue, Integer> valueSetter = entry.getKey();

            valueSetter.accept(sue, value);
        }

        return sue;
    }

    public static Map<BiConsumer<Sue, Integer>, Integer> createSetUp(List<String> parameters, List<Integer> values) {
        Map<BiConsumer<Sue, Integer>, Integer> setUp = new HashMap<>();

        for (Integer i = 0; i < parameters.size(); i++) {
            BiConsumer<Sue, Integer> valueSetter = getValueSetter(parameters.get(i));
            Integer value = values.get(i);

            setUp.put(valueSetter, value);
        }

        return setUp;
    }

    private static BiConsumer<Sue, Integer> getValueSetter(String s) {
        switch(s) {
            case "Sue":
                return Sue::setId;
            case "children":
                return Sue::setChildren;
            case "cats":
                return Sue::setCats;
            case "samoyeds":
                return Sue::setSamoyeds;
            case "pomeranians":
                return Sue::setPomeranians;
            case "akitas":
                return Sue::setAkitas;
            case "vizslas":
                return Sue::setVizslas;
            case "goldfish":
                return Sue::setGoldfish;
            case "trees":
                return Sue::setTrees;
            case "cars":
                return Sue::setCars;
            case "perfumes":
                return Sue::setPerfumes;
        }

        return null;
    }

    public static Sue createGiftSue() {
        return new Sue(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);
    }

    public static Integer getCorrectSue(List<Sue> sues, Sue giftSue) {
        for (Sue sue : sues) {
            Map<String, Integer> parametersAndValues = new HashMap<>();

            Integer children = sue.getChildren();
            Integer cats = sue.getCats();
            Integer samoyeds = sue.getSamoyeds();
            Integer pomeranians = sue.getPomeranians();
            Integer akitas = sue.getAkitas();
            Integer vizslas = sue.getVizslas();
            Integer goldfish = sue.getGoldfish();
            Integer trees = sue.getTrees();
            Integer cars = sue.getCars();
            Integer perfumes = sue.getPerfumes();

            addParameters(parametersAndValues, children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes);

            boolean b = true;

            for (Map.Entry<String, Integer> entry : parametersAndValues.entrySet()) {
                String parameter = entry.getKey();
                Integer expectedValue = entry.getValue();

                Integer actualValue = getActualValue(parameter, giftSue);

                if (parameter.equals("cats") || parameter.equals("trees")) {
                    if (expectedValue <= actualValue) {
                        b = false;
                    }
                } else if (parameter.equals("pomeranians") || parameter.equals("goldfish")) {
                    if (expectedValue >= actualValue) {
                        b = false;
                    }
                } else {
                    if (expectedValue != actualValue) {
                        b = false;
                    }
                }
            }

            if (b) {
                return sue.getId();
            }
        }

        return Integer.MAX_VALUE;
    }

    private static Integer getActualValue(String parameter, Sue giftSue) {
        switch(parameter) {
            case "children":
                return giftSue.getChildren();
            case "cats":
                return giftSue.getCats();
            case "samoyeds":
                return giftSue.getSamoyeds();
            case "pomeranians":
                return giftSue.getPomeranians();
            case "akitas":
                return giftSue.getAkitas();
            case "vizslas":
                return giftSue.getVizslas();
            case "goldfish":
                return giftSue.getGoldfish();
            case "trees":
                return giftSue.getTrees();
            case "cars":
                return giftSue.getCars();
            case "perfumes":
                return giftSue.getPerfumes();
        }

        return Integer.MAX_VALUE;
    }

    private static void addParameters(Map<String, Integer> parametersAndValues, Integer children, Integer cats, Integer samoyeds, Integer pomeranians, Integer akitas, Integer vizslas, Integer goldfish, Integer trees, Integer cars, Integer perfumes) {
        if (children != null) {
            parametersAndValues.put("children", children);
        }

        if (cats != null) {
            parametersAndValues.put("cats", cats);
        }

        if (samoyeds != null) {
            parametersAndValues.put("samoyeds", samoyeds);
        }

        if (pomeranians != null) {
            parametersAndValues.put("pomeranians", pomeranians);
        }

        if (akitas != null) {
            parametersAndValues.put("akitas", akitas);
        }

        if (vizslas != null) {
            parametersAndValues.put("vizslas", vizslas);
        }

        if (goldfish != null) {
            parametersAndValues.put("goldfish", goldfish);
        }

        if (trees != null) {
            parametersAndValues.put("trees", trees);
        }

        if (cars != null) {
            parametersAndValues.put("cars", cars);
        }

        if (perfumes != null) {
            parametersAndValues.put("perfumes", perfumes);
        }
    }
}
