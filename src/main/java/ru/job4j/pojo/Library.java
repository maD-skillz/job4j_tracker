package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 500);
        Book unnamed1 = new Book("Unnamed1", 150);
        Book unnamed2 = new Book("Unnamed2", 120);
        Book unnamed3 = new Book("Unnamed3", 300);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = unnamed1;
        books[2] = unnamed2;
        books[3] = unnamed3;

       for (int i = 0; i < books.length; i++) {
            Book count = books[i];
            System.out.println(count.getName());
       }

       books[0] = unnamed3;
       books[3] = cleanCode;
        for (int j = 0; j < books.length; j++) {
            Book count2 = books[j];
            System.out.println(count2.getName());

            if (books[j].getName().equals("Clean Code")) {
                System.out.println(count2.getName());
            }
        }
    }
}
