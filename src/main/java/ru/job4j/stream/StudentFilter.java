package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentFilter {
    public static Map<String, Student> filter(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname, e -> e,
                        (f, e) -> f
                ));
    }
}
