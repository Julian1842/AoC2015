package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static Enemy generateEnemy(List<String> lines) {
        String[] split1 = lines.get(0).split(": ");
        String[] split2 = lines.get(1).split(": ");

        return new Enemy(Integer.parseInt(split1[1]), Integer.parseInt(split2[1]));
    }

    public static List<Spell> generateSpells() {
        List<Spell> spells = new ArrayList<>();

        spells.add(new Spell("Magic Missile", 53, 1));
        spells.add(new Spell("Drain", 73, 1));
        spells.add(new Spell("Shield", 113, 6));
        spells.add(new Spell("Poison", 173, 6));
        spells.add(new Spell("Recharge", 229, 5));

        return spells;
    }
}
