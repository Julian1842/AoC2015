package com.company;

public class Utility {
    private String name;
    private int cost;
    private int damage;
    private int armor;

    public Utility(String name, int cost, int damage, int armor) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
