package com.company;

public class Cookie {
    private int capacity;
    private int durability;
    private int flavor;
    private int texture;
    private int score;

    public Cookie(int capacity, int durability, int flavor, int texture) {
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;

        score = capacity * durability * flavor * texture;
    }

    public int getScore() {
        return score;
    }
}
