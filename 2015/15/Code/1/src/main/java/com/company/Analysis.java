package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static List<Ingredient> createIngredients(List<String> lines) {
        List<Ingredient> ingredients = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(" ");

            String name = split[0].substring(0, split[0].length() - 1);
            int capacity = Integer.parseInt(split[2].substring(0, split[2].length() - 1));
            int durability = Integer.parseInt(split[4].substring(0, split[4].length() - 1));
            int flavor = Integer.parseInt(split[6].substring(0, split[6].length() - 1));
            int texture = Integer.parseInt(split[8].substring(0, split[8].length() - 1));
            int calories = Integer.parseInt(split[10]);

            ingredients.add(new Ingredient(name, capacity, durability, flavor, texture, calories));
        }

        return ingredients;
    }

    public static List<Cookie> createPossibleCookiesFrom(List<Ingredient> ingredients) {
        List<Cookie> cookies = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {

            for (int j = 0; j <= 100 - i; j++) {

                for (int k = 0; k <= 100 - i - j; k++) {

                    int l = 100 - i - j - k;

                    int capacity = ((i * ingredients.get(0).getCapacity()) + (j * ingredients.get(1).getCapacity()) + (k * ingredients.get(2).getCapacity()) + (l * ingredients.get(3).getCapacity()));
                    int durability = ((i * ingredients.get(0).getDurability()) + (j * ingredients.get(1).getDurability()) + (k * ingredients.get(2).getDurability()) + (l * ingredients.get(3).getDurability()));
                    int flavor = ((i * ingredients.get(0).getFlavor()) + (j * ingredients.get(1).getFlavor()) + (k * ingredients.get(2).getFlavor()) + (l * ingredients.get(3).getFlavor()));
                    int texture = ((i * ingredients.get(0).getTexture()) + (j * ingredients.get(1).getTexture()) + (k * ingredients.get(2).getTexture()) + (l * ingredients.get(3).getTexture()));

                    if (capacity < 0) {
                        capacity = 0;
                    }

                    if (durability < 0) {
                        capacity = 0;
                    }

                    if (flavor < 0) {
                        flavor = 0;
                    }

                    if (texture < 0) {
                        texture = 0;
                    }

                    cookies.add(new Cookie(capacity, durability, flavor, texture));
                }
            }
        }

        return cookies;
    }

    public static int getBestScoringCookie(List<Cookie> cookies) {
        int currentBest = Integer.MIN_VALUE;

        for (Cookie cookie : cookies) {
            int currentScore = cookie.getScore();

            if (currentScore > currentBest) {
                currentBest = currentScore;
            }
        }

        return currentBest;
    }

}
