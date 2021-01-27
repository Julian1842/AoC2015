package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReindeerTest {
    @Test
    void startRace1() {
        //given
        List<Reindeer> reindeers = List.of(new Reindeer("Comet", 14, 10, 127), new Reindeer("Dancer", 16, 11, 162));
        int seconds = 1000;

        int expected = 1120;

        //when
        int actual = Main.startRace(reindeers, seconds);

        //then
        assertEquals(expected, actual);
    }
}