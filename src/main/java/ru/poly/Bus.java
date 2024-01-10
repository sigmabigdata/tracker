package ru.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Перевозит пасажиров");
    }

    @Override
    public void passanger(int passenger) {
        System.out.println("Перевозит пассажиров: " + passenger);
    }

    @Override
    public double prise(double fuel) {
        double prise = fuel * 52.10;
        return prise;
    }
}
