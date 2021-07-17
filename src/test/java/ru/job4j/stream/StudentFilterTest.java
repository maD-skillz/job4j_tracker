package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentFilterTest {
    @Test
    public void whenListToMap() {
        List<Student> students = Arrays.asList(
                new Student(30, "Petrov"),
                new Student(35, "Boshyrov"),
                new Student(90, "Bond"),
                new Student(50, "Newman")
        );
        Map<String, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getSurname(), student);
        }
        assertThat(StudentFilter.filter(students), is(studentMap));
    }
}