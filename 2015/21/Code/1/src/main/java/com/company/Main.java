package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        Analysis analysis = new Analysis();

        List<String> lines = Reader.readFile(PATH);
        List<List<String>> parts = analysis.splitLine(lines);

        List<Weapon> weapons = analysis.createWeapons();
        List<Armor> armors = analysis.createArmors();
        List<Ring> rings = analysis.createRings();

        List<Player> allPossiblePlayers = analysis.getAllPossiblePlayers(weapons, armors, rings);

        List<List<Integer>> results = new ArrayList<>();



        for (Player player : allPossiblePlayers) {
            Enemy enemy = analysis.createEnemy(parts);

            Battle battle = new Battle(player, enemy);
            List<Integer> result = battle.battle();

            results.add(result);
        }

        int lowestCostWin = analysis.getLowestCostWin(results);

        System.out.println(lowestCostWin);
    }
}

