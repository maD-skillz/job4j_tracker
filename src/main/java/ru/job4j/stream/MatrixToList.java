package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
