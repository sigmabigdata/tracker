package ru.poly;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passanger(5);
        System.out.println("Стоимость топлива: " + bus.prise(100));
    }
}
