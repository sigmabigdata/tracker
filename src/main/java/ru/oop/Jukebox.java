package ru.oop;

import javax.swing.text.Position;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        int first = 1;
        int second = 2;
        int third = 3;
        Jukebox kolya = new Jukebox();
        kolya.music(first);
        kolya.music(second);
        kolya.music(third);
    }
}
