package com.company;

public class Cookie {
    private int capacity;
    private int durability;
    private int flavor;
    private int texture;
    private int calories;
    private int score;

    public Cookie(int capacity, int durability, int flavor, int texture, int calories) {
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;

        score = capacity * durability * flavor * texture;
    }

    public int getScore() {
        return score;
    }

    public int getCalories() {
        return calories;
    }
}
