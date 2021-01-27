package com.company;

public class Player {
    private int mana = 500;
    private int hitPoints = 50;
    private int shield = 0;

    public void reduceHitPointsBy(int amount) {
        hitPoints -= amount;
    }

    public void increaseHitPointsBy(int amount) {
        hitPoints += amount;
    }

    public int getMana() {
        return mana;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void reduceShieldBy(int amount) {
        shield -= amount;
    }

    public void increaseManaBy(int amount) {
        mana += amount;
    }

    public void reduceManaBy(int amount) {
        mana -= amount;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
