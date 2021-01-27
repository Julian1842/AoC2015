package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightsTest {

    @Test
    void changeLights1() {
        //given
        List<String> input = List.of("turn on 0,0 through 999,999");

        int expected = 1000000;

        Lights lights = new Lights();

        //when
        lights.changeLights(input);

        int actual = lights.getAmountOfTurnedOnLights();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void changeLights2() {
        //given
        List<String> input = List.of("toggle 0,0 through 999,0");

        int expected = 1000;

        Lights lights = new Lights();

        //when
        lights.changeLights(input);

        int actual = lights.getAmountOfTurnedOnLights();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void changeLights3() {
        //given
        List<String> input = List.of("turn off 499,499 through 500,500");

        int expected = 0;

        Lights lights = new Lights();

        //when
        lights.changeLights(input);

        int actual = lights.getAmountOfTurnedOnLights();

        //then
        assertEquals(expected, actual);
    }
}