package ru.pojo;

public class Library extends Book {

    public static void main(String[] args) {
        Book fire = new Book();
        Book ice = new Book();
        Book wind = new Book();
        Book cleanCode = new Book();
        fire.setName("Fire");
        ice.setName("Ice");
        wind.setName("Wind");
        cleanCode.setName("Clean Code");

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
            if (lib.getName().equals("Clean Code")) {
                System.out.println(lib.getName());
            }
        }
    }
}
