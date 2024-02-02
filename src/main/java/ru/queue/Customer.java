package ru.queue;

public record Customer(String name, int amount) {

    public String getName() {
        return name;
    }
}