package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> stats = Reader.readFile(PATH);

        List<Reindeer> reindeers = Analysis.getReindeersFrom(stats);

        int seconds = 2503;

        int winningDistance = startRace(reindeers, seconds);

        System.out.println(winningDistance);
    }

    public static int startRace(List<Reindeer> reindeers, int seconds) {
        int currentBestDistance = Integer.MIN_VALUE;

        for (Reindeer reindeer : reindeers) {
            int distance = reindeer.fly(seconds);

            if (distance > currentBestDistance) {
                currentBestDistance = distance;
            }
        }

        return currentBestDistance;
    }
}
