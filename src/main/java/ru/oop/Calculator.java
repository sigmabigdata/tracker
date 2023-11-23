package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return x - z;
    }

    public int divide(int j) {
        return x / j;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslSum = sum(10);
        int rslMult = calculator.multiply(5);
        int rslMinus = minus(2);
        int rslDivide = calculator.divide(1);
        System.out.println(rslSum);
        System.out.println(rslMult);
        System.out.println(rslMinus);
        System.out.println(rslDivide);
    }
}
