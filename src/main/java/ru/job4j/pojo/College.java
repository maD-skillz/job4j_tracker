package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Peter");
        student.setGroup("1");
        student.setCreated(new Date());

        System.out.println("Студент " + student.getName() + " учится в руппе номер "
                + student.getGroup() + " c " + student.getCreated());

    }
}
