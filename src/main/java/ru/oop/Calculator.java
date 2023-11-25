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
        return z - x;
    }

    public int divide(int j) {
        return j / x;
    }

    public int sumAllOperation(int k) {
        return multiply(k) + minus(k) + divide(k) + sum(k);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslSum = sum(10);
        int rslMult = calculator.multiply(5);
        int rslMinus = minus(2);
        int rslDivide = calculator.divide(1);
        int rslRsl = calculator.sumAllOperation(3);
        System.out.println(rslSum);
        System.out.println(rslMult);
        System.out.println(rslMinus);
        System.out.println(rslDivide);
        System.out.println(rslRsl);
    }
}
