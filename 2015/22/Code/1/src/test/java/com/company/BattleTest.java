package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleTest {
    @Test
    void battle1() {
        //given
        List<Spell> spells = Analysis.generateSpells();

        int wins = 0;

        //when
        for (int i = 0; i < 1000; i++) {
            Player player = new Player();
            player.setHitPoints(10);
            player.setMana(250);

            Enemy enemy = new Enemy(13, 8);


            List<Integer> result = Battle.battle(player, enemy, spells);

            wins += result.get(0);
        }

        //then
        assertTrue(wins >= 1);
    }
}