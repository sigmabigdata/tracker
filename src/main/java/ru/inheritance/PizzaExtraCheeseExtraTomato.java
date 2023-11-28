package ru.inheritance;

public class PizzaExtraCheeseExtraTomato extends Pizza {

    private static final String TOPPING_TOMATO = " + extra cheese + extra tomato";

    @Override
    public String name() {
        return super.name() + TOPPING_TOMATO;
    }
}
