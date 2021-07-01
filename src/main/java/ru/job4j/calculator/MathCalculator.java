package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {

    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double sumBySubAndDiv(double first, double second) {
        return sub(first, second)
                + div(first, second);
    }

    public static double allSum(double first, double second) {
        return sumAndMultiply(first, second) + sumBySubAndDiv(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат расчёта равен: " + allSum(10, 20));
    }
}
