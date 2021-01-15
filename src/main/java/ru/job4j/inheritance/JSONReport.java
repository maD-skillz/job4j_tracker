package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}
