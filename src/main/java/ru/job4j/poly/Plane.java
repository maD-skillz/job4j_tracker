package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getName()  + " летит по воздуху.");
    }
}
