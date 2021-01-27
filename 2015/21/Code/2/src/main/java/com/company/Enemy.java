package com.company;

public class Enemy {
    private int hitPoints;
    private int attack;
    private int defense;

    public Enemy(int hitPoints, int attack, int defense) {
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void reduceHitPointsBy(int reduce) {
        hitPoints -= reduce;
    }
}
