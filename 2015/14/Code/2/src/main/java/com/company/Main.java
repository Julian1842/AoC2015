package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> stats = Reader.readFile(PATH);

        List<Reindeer> reindeers = Analysis.getReindeersFrom(stats);

        int winningPoints = startRace(reindeers, 2503);

        System.out.println(winningPoints);
    }


    public static int startRace(List<Reindeer> reindeers, int seconds) {
        for (int i = 1; i <= seconds; i++) {

            int currentMaxDistance = Integer.MIN_VALUE;
            List<Reindeer> winningReindeers = new ArrayList<>();
            Reindeer winningReindeer = null;

            for (Reindeer reindeer : reindeers) {
                reindeer.flyOneSecond();
            }

            for (Reindeer reindeer : reindeers) {
                int currentDistance = reindeer.getCurrentDistance();

                if (currentDistance > currentMaxDistance) {
                    currentMaxDistance = currentDistance;
                    winningReindeer = reindeer;
                }
            }

            for (Reindeer reindeer : reindeers) {
                assert winningReindeer != null;
                int winningReindeerPoints = winningReindeer.getCurrentDistance();

                if (reindeer.getCurrentDistance() == winningReindeerPoints) {
                    winningReindeers.add(reindeer);
                }
            }

            winningReindeers.forEach(Reindeer::addPoint);
        }

        int currentMaxPoints = Integer.MIN_VALUE;

        for (Reindeer reindeer : reindeers) {
            int currentPoints = reindeer.getPoints();

            if (currentPoints > currentMaxPoints) {
                currentMaxPoints = currentPoints;
            }
        }

        return currentMaxPoints;
    }
}
