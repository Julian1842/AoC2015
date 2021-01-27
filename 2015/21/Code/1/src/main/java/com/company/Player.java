package com.company;

import java.util.List;

public class Player {
    private int hitPoints = 100;
    private Weapon weapon;
    private List<Armor> armors;
    private List<Ring> rings;

    private int totalCost = 0;
    private int attack = 0;
    private int defense = 0;

    public Player(Weapon weapon, List<Armor> armors, List<Ring> rings) {
        this.weapon = weapon;
        this.armors = armors;
        this.rings = rings;

        setTotalCost(weapon, armors, rings);
        setAttack(weapon, armors, rings);
        setDefense(weapon, armors, rings);
    }

    private void setAttack(Weapon weapon, List<Armor> armors, List<Ring> rings) {
        attack += weapon.getDamage();

        for (Armor armor : armors) {
            attack += armor.getDamage();
        }

        for (Ring ring : rings) {
            attack += ring.getDamage();
        }
    }

    private void setDefense(Weapon weapon, List<Armor> armors, List<Ring> rings) {
        defense += weapon.getArmor();

        for (Armor armor : armors) {
            defense += armor.getArmor();
        }

        for (Ring ring : rings) {
            defense += ring.getArmor();
        }
    }

    private void setTotalCost(Weapon weapon, List<Armor> armors, List<Ring> rings) {
        totalCost += weapon.getCost();

        for (Armor armor : armors) {
            totalCost += armor.getCost();
        }

        for (Ring ring : rings) {
            totalCost += ring.getCost();
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void reduceHitPointsBy(int reduce) {
        hitPoints -= reduce;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
