package com.company;

public class Enemy {
    private int hitPoints;
    private final int damage;

    public Enemy(int hitPoints, int damage) {
        this.hitPoints = hitPoints;
        this.damage = damage;
    }

    public void reduceHitPointsBy(int amount) {
        this.hitPoints -= amount;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
