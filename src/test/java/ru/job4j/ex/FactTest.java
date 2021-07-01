package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLowerThenZero() {
        new Fact().calc(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNLowerThenZero2() {
        new Fact().calc(-12);
    }
}