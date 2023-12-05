package ru.pojo;

public class Library {

    public static void main(String[] args) {
        Book fire = new Book("Fire");
        Book ice = new Book("Ice");
        Book wind = new Book("Wind");
        Book cleanCode = new Book("Clean Code");

        Book[] library = new Book[4];
        library[0] = fire;
        library[1] = ice;
        library[2] = wind;
        library[3] = cleanCode;

        System.out.println("Спискок книг до замены: ");

        for (int index = 0; index < library.length; index++) {
            Book lib = library[index];
            System.out.println(lib.getName());
        }

        System.out.println();
        System.out.println("Список кник после замены:");

        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;

        for (int index = 0; index < library.length; index++) {
            Book lib = library[index];
            System.out.println(lib.getName());
        }

        System.out.println();
        System.out.println("Печать только названия определенной книги: ");

        for (int index = 0; index < library.length; index++) {
            Book lib = library[index];
            if ("Clean Code".equals(lib.getName())) {
                System.out.println(lib.getName());
            }
        }
    }
}
