package ru.ex;

public class Factorial {
    public static int calc(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Введенное значение меньше 1");
        }
        int result = 1;
        for (int index = 2; index <= number; index++) {
            result *= index;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().calc(-1));
    }
}