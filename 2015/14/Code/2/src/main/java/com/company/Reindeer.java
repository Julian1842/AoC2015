package com.company;

public class Reindeer {
    private String name;
    private int speed;
    private int flyingTime;
    private int restingTime;
    private int currentDistance;
    private int points;
    int flyingSecondsLeft;
    int restingSecondsLeft;

    public Reindeer(String name, int speed, int flyingTime, int restingTime) {
        this.name = name;
        this.speed = speed;
        this.flyingTime = flyingTime;
        this.restingTime = restingTime;

        this.flyingSecondsLeft = flyingTime;
        this.restingSecondsLeft = restingTime;
    }

    public void flyOneSecond() {
        int totalDistance = 0;

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

        this.currentDistance += totalDistance;
    }

    public String getName() {
        return name;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public void addPoint() {
        this.points += 1;
    }

    public int getPoints() {
        return points;
    }
}
