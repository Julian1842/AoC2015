package com.company;

import java.util.*;

public class Battle {
    public static final String SHIELD_TIMER = "shieldTimer";
    public static final String POISON_TIMER = "poisonTimer";
    public static final String RECHARGE_TIMER = "rechargeTimer";
    
    public static List<Integer> battle(Player player, Enemy enemy, List<Spell> availableSpells) {
        int totalSpent = 0;

        Map<String, Integer> timers = new HashMap<>();

        timers.put(SHIELD_TIMER, 0);
        timers.put(POISON_TIMER, 0);
        timers.put(RECHARGE_TIMER, 0);

        while (true) {
            // Player turn
            player.reduceHitPointsBy(1);

            if (player.getHitPoints() <= 0) {
                return List.of(0, totalSpent);
            }

            timers = applyEffects(player, enemy, timers);

            List<Spell> possibleSpellsToCast = getPossibleSpellsToCast(availableSpells, timers, player);

            if (possibleSpellsToCast.size() == 0) {
                return List.of(0, totalSpent);
            }

            int randomSpellToCast = getRandomNumber(possibleSpellsToCast.size());
            Spell spellToCast = possibleSpellsToCast.get(randomSpellToCast);

            totalSpent += spellToCast.getCost();
            player.reduceManaBy(spellToCast.getCost());

            timers = castSpellOrAddTimer(player, enemy, timers, availableSpells, spellToCast);


            // Enemy turn
            timers = applyEffects(player, enemy, timers);

            if (stopIfPlayerWonAgainst(enemy)) {
                return List.of(1, totalSpent);
            }

            if (timers.get(SHIELD_TIMER) > 0) {
                int damage = enemy.getDamage() - 7;

                player.reduceHitPointsBy(Math.max(damage, 1));
            } else {
                player.reduceHitPointsBy(enemy.getDamage());
            }
            
            if (stopIfEnemyWonAgainst(player)) {
                return List.of(0, totalSpent);
            }
        }
    }

    private static Map<String, Integer> castSpellOrAddTimer(Player player, Enemy enemy, Map<String, Integer> timers, List<Spell> availableSpells, Spell spellToCast) {
        Map<String, Integer> newMap = new HashMap<>(timers);

        if (spellToCast.getName().equals("Magic Missile")) {
            enemy.reduceHitPointsBy(4);
        } else if (spellToCast.getName().equals("Drain")) {
            enemy.reduceHitPointsBy(2);
            player.increaseHitPointsBy(2);
        } else if (spellToCast.getName().equals("Shield")) {
            newMap.put(SHIELD_TIMER, 6);
        } else if (spellToCast.getName().equals("Poison")) {
            newMap.put(POISON_TIMER, 6);
        } else if (spellToCast.getName().equals("Recharge")) {
           newMap.put(RECHARGE_TIMER, 5);
        }

        return newMap;
    }

    private static boolean stopIfEnemyWonAgainst(Player player) {
        return ((player.getHitPoints() <= 0) || (player.getMana() <= 0));
    }

    private static boolean stopIfPlayerWonAgainst(Enemy enemy) {
        return (enemy.getHitPoints() <= 0);
    }

    private static Map<String, Integer> applyEffects(Player player, Enemy enemy, Map<String, Integer> timers) {
        int shieldTimer = timers.get(SHIELD_TIMER);
        int poisonTimer = timers.get(POISON_TIMER);
        int rechargeTimer = timers.get(RECHARGE_TIMER);

        Map<String, Integer> newMap = new HashMap<>(timers);
        
        if (shieldTimer > 0) {
            player.setShield(7);
            newMap.put(SHIELD_TIMER, shieldTimer -= 1);
        }

        if (poisonTimer > 0) {
            enemy.reduceHitPointsBy(3);
            newMap.put(POISON_TIMER, poisonTimer -= 1);
        }

        if (rechargeTimer > 0) {
            player.increaseManaBy(101);
            newMap.put(RECHARGE_TIMER, rechargeTimer -= 1);
        }
        
        return newMap;
    }

    private static int getRandomNumber(int i) {
        Random random = new Random();
        return random.nextInt(i);
    }

    private static List<Spell> getPossibleSpellsToCast(List<Spell> availableSpells, Map<String, Integer> timers, Player player) {
        List<Spell> possibleSpells = new ArrayList<>();

        for (Spell spell : availableSpells) {
            if (spell.getName().equals("Shield")) {
                if (timers.get(SHIELD_TIMER) == 0 && spell.getCost() <= player.getMana()) {
                    possibleSpells.add(spell);
                }
            } else if (spell.getName().equals("Poison")) {
                if (timers.get(POISON_TIMER) == 0 && spell.getCost() <= player.getMana()) {
                    possibleSpells.add(spell);
                }
            } else if (spell.getName().equals("Recharge")) {
                if (timers.get(RECHARGE_TIMER) == 0 && spell.getCost() <= player.getMana()) {
                    possibleSpells.add(spell);
                }
            } else if (spell.getCost() <= player.getMana()) {
                possibleSpells.add(spell);
            }
        }

        return possibleSpells;
    }

}
