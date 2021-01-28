package ru.job4j.pojo;

public class Book {
    private String name;
    private int sheets;

    public Book(String name, int sheets) {
        this.name = name;
        this.sheets = sheets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }
}
