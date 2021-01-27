package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PasswordTest {

    @Test
    void isValid1() {
        //given
        String password = "hijklmmn";

        //when
        boolean actual = Password.isValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    void isValid2() {
        //given
        String password = "abbceffg";

        //when
        boolean actual = Password.isValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    void isValid3() {
        //given
        String password = "abbcegjk";

        //when
        boolean actual = Password.isValid(password);

        //then
        assertFalse(actual);
    }

    @Test
    void generateNewPassword1() {
        //given
        String actual = "abcdefgh";

        String expected = "abcdffaa";

        //when
        while(!Password.isValid(actual)) {
            actual = Password.generateNewPassword(actual);
        }

        //then
        assertEquals(expected, actual);
    }

    @Test
    void generateNewPassword2() {
        //given
        String actual = "ghijklmn";

        String expected = "ghjaabcc";

        //when
        while(!Password.isValid(actual)) {
            actual = Password.generateNewPassword(actual);
        }

        //then
        assertEquals(expected, actual);
    }
}