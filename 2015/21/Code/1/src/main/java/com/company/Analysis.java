package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analysis {
    private List<List<Armor>> armorCombinations = new ArrayList<>();

    public List<List<String>> splitLine(List<String> lines) {
        List<List<String>> parts = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(": ");

            List<String> splitLine = new ArrayList<>(Arrays.asList(split));

            parts.add(splitLine);
        }

        return parts;
    }

    public Enemy createEnemy(List<List<String>> parts) {
        int hitPoints = Integer.parseInt(parts.get(0).get(1));
        int damage = Integer.parseInt(parts.get(1).get(1));
        int armor = Integer.parseInt(parts.get(2).get(1));

        return new Enemy(hitPoints, damage, armor);
    }

    public List<Ring> createRings() {
        List<Ring> rings = new ArrayList<>();

        rings.add(new Ring("Damage +1", 25, 1, 0));
        rings.add(new Ring("Damage +2", 50, 2, 0));
        rings.add(new Ring("Damage +3", 100, 3, 0));
        rings.add(new Ring("Defense +1", 20, 0, 1));
        rings.add(new Ring("Defense +2", 40, 0, 2));
        rings.add(new Ring("Defense +3", 80, 0, 3));

        return rings;
    }

    public List<Armor> createArmors() {
        List<Armor> armors = new ArrayList<>();

        armors.add(new Armor("Leather", 13, 0, 1));
        armors.add(new Armor("Chainmail", 31, 0, 2));
        armors.add(new Armor("Splintmail", 53, 0, 3));
        armors.add(new Armor("Bandedmail", 75, 0, 4));
        armors.add(new Armor("Platemail", 102, 0, 5));

        return armors;
    }

    public List<Weapon> createWeapons() {
        List<Weapon> weapons = new ArrayList<>();

        weapons.add(new Weapon("Dagger", 8, 4, 0));
        weapons.add(new Weapon("Shortsword", 10, 5, 0));
        weapons.add(new Weapon("Warhammer", 25, 6, 0));
        weapons.add(new Weapon("Longsword", 40, 7, 0));
        weapons.add(new Weapon("Greataxe", 74, 8, 0));

        return weapons;
    }

    public List<Player> getAllPossiblePlayers(List<Weapon> weapons, List<Armor> armors, List<Ring> rings) {
        List<Player> players = new ArrayList<>();

        Permutation.permute(rings);
        List<List<Ring>> ringPermutes = Permutation.ringCombinations;

        for (Weapon weapon : weapons) {

            players.add(new Player(weapon, List.of(), List.of())); // 0 armor 0 ring

            for (Ring ring : rings) { // 0 armor 1 ring
                players.add(new Player(weapon, List.of(), List.of(ring)));
            }

            for (List<Ring> permutes : ringPermutes) { // 0 armor 2 ring
                players.add(new Player(weapon, List.of(), permutes));
            }

            for (Armor armor : armors) {

                players.add(new Player(weapon, List.of(armor), List.of())); // 1 armor 0 ring

                for (Ring ring : rings) {
                    players.add(new Player(weapon, List.of(armor), List.of(ring))); // 1 armor 1 ring
                }

                for (List<Ring> permutes : ringPermutes) { // 1 armor 2 ring
                    players.add(new Player(weapon, List.of(armor), permutes));
                }
            }

        }

        return players;
    }

    public int getLowestCostWin(List<List<Integer>> results) {
        int currentLowest = Integer.MAX_VALUE;

        for (List<Integer> result : results) {
            if (result.get(0) == 1) {
                if (currentLowest > result.get(1)) {
                    currentLowest = result.get(1);
                }
            }
        }

        return currentLowest;
    }
}
