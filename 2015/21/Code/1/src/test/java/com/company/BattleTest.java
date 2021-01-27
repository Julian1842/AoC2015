package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    void battle() {
        //given
        Weapon weapon = new Weapon("test", 0, 5, 5);

        Player player = new Player(weapon, List.of(), List.of());
        player.setHitPoints(8);
        Enemy enemy = new Enemy(12, 7, 2);
        Battle battle = new Battle(player, enemy);

        //when
        List<Integer> result = battle.battle();

        //then
        assertEquals(1, result.get(0));
    }

}