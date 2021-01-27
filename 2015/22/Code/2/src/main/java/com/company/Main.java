package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);



        List<Spell> spells = Analysis.generateSpells();

        int currentSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < 10000000; i++) {
            Enemy enemy = Analysis.generateEnemy(lines);
            Player player = new Player();

            List<Integer> results = Battle.battle(player, enemy, spells);

            if (results.get(0) == 1 && results.get(1) < currentSmallest) {
                currentSmallest = results.get(1);
            }

        }

        System.out.println(currentSmallest);
    }
}
