package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);

        List<Ingredient> ingredients = Analysis.createIngredients(lines);
        List<Cookie> cookies = Analysis.createPossibleCookiesFrom(ingredients);
        int bestScoringCookie = Analysis.getBestScoringCookie(cookies);

        System.out.println(bestScoringCookie);
    }
}
