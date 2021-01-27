package com.company;

import java.util.List;

public class Battle {
    private Player player;
    private Enemy enemy;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public List<Integer> battle() {
        int playerAttack = player.getAttack();
        int playerDefense = player.getDefense();

        int enemyAttack = enemy.getAttack();
        int enemyDefense = enemy.getDefense();



        while(true) {
            int playerDamage = playerAttack - enemyDefense;

            enemy.reduceHitPointsBy(Math.max(playerDamage, 1));

            if (enemy.getHitPoints() <= 0) {
                return List.of(1, player.getTotalCost());
            }

            int enemyDamage = enemyAttack - playerDefense;

            player.reduceHitPointsBy(Math.max(enemyDamage, 1));

            if (player.getHitPoints() <= 0) {
                return List.of(0, player.getTotalCost());
            }
        }
    }
}
