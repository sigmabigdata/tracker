package ru.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                rsl[index] = name;
                size++;
            }
        }
        rsl = Arrays.copyOf(items, size);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] copyItems = new Item[items.length];
        int i = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name.getName().equals(key)) {
                copyItems[index] = name;
                i++;
            }
        }
        copyItems = Arrays.copyOf(items, i);
        return copyItems;
    }
}