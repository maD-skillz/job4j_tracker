package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    public static void main(String[] args) {
        TextReport JSONReport = new TextReport();
        String text = JSONReport.generate("name", "body");
        System.out.println(text);
    }
}
