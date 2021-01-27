package com.company;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class HashingTest {

    @Test
    void hash1() throws NoSuchAlgorithmException {
        //given
        String input = "abcdef";

        String expected = "609043";

        //when
        String actual = Hashing.hash(input);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void hash2() throws NoSuchAlgorithmException {
        //given
        String input = "pqrstuv";

        String expected = "1048970";

        //when
        String actual = Hashing.hash(input);

        //then
        assertEquals(expected, actual);
    }
}