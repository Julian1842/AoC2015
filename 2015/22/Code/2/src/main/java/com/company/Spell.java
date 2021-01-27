package com.company;

public class Spell {
    private String name;
    private int cost;
    private int roundsLeft;

    public Spell(String name, int cost, int roundsLeft) {
        this.name = name;
        this.cost = cost;
        this.roundsLeft = roundsLeft;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRoundsLeft() {
        return roundsLeft;
    }

    public void reduceRoundsLeftBy(int amount) {
        roundsLeft -= amount;
    }
}
