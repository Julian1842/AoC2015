package com.company;

public class Register {
    public int value = 0;
    public final String name;

    public Register(final String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("%s (%d)", this.name, this.value);
    }
}
