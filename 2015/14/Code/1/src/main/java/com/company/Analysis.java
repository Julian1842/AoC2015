package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static List<Reindeer> getReindeersFrom(List<String> stats) {
        List<Reindeer> reindeers = new ArrayList<>();

        for (String stat : stats) {
            String[] split = stat.split(" ");

            String name = split[0];
            int speed = Integer.parseInt(split[3]);
            int flyingTime = Integer.parseInt(split[6]);
            int restingTime = Integer.parseInt(split[13]);

            Reindeer reindeer = new Reindeer(name, speed, flyingTime, restingTime);

            reindeers.add(reindeer);
        }

        return reindeers;
    }
}
