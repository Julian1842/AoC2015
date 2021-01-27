package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void getBestScoringCookie1() {
        //given
        List<Ingredient> ingredients = List.of(new Ingredient("Butterscotch", -1, -2, 6, 3, 8), new Ingredient("Cinnamon", 2, 3, -2, -1, 3));
        List<Cookie> cookies = dummyCreatePossibleCookiesFrom(ingredients);

        int expected = 57600000;

        //when
        int actual = Analysis.getBestScoringCookie(cookies);

        //then
        assertEquals(expected, actual);
    }

    public static List<Cookie> dummyCreatePossibleCookiesFrom(List<Ingredient> ingredients) {
        List<Cookie> cookies = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {

            for (int j = 0; j <= 100 - i; j++) {

                int capacity = ((i * ingredients.get(0).getCapacity()) + (j * ingredients.get(1).getCapacity()));
                int durability = ((i * ingredients.get(0).getDurability()) + (j * ingredients.get(1).getDurability()));
                int flavor = ((i * ingredients.get(0).getFlavor()) + (j * ingredients.get(1).getFlavor()));
                int texture = ((i * ingredients.get(0).getTexture()) + (j * ingredients.get(1).getTexture()));
                int calories = ((i * ingredients.get(0).getCalories()) + (j * ingredients.get(1).getCalories()));

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

                cookies.add(new Cookie(capacity, durability, flavor, texture, calories));
            }
        }

        return cookies;
    }
}