package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    public void main(String[] args) {
        TextReport newJSONReport = new TextReport();
        String text = newJSONReport.generate("name", "body");
        System.out.println(text);
    }
}
