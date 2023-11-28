package ru.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String TOPPING_CHEESE = " + extra cheese";

    @Override
    public String name() {
        return super.name() + TOPPING_CHEESE;
    }
}
