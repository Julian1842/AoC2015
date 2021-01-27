package com.company;

public class Reindeer {
    private String name;
    private int speed;
    private int flyingTime;
    private int restingTime;

    public Reindeer(String name, int speed, int flyingTime, int restingTime) {
        this.name = name;
        this.speed = speed;
        this.flyingTime = flyingTime;
        this.restingTime = restingTime;
    }

    public int fly(int seconds) {
        int totalDistance = 0;

        int flyingSecondsLeft = flyingTime;
        int restingSecondsLeft = restingTime;

        for (int i = 1; i <= seconds; i++) {
            if (flyingSecondsLeft > 0) {
                totalDistance += speed;
                flyingSecondsLeft--;
            } else if (restingSecondsLeft > 0) {
                restingSecondsLeft--;
            } else if (restingSecondsLeft == 0) {
                flyingSecondsLeft = flyingTime - 1;
                restingSecondsLeft = restingTime;
                totalDistance += speed;
            }
        }

        return totalDistance;
    }

    public String getName() {
        return name;
    }
}
