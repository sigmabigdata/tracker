package ru.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item[] findByName(String key) {
        Item[] copyItems = new Item[size];
        int i = 0;
        for (int index = 0; index < size; index++) {
            Item name = items.get(index);
            if (name.getName().equals(key)) {
                copyItems[i] = name;
                i++;
            }
        }
        return Arrays.copyOf(copyItems, i);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int indexId = indexOf(id);
        if (indexId != -1) {
            item.setId(id);
            items.set(indexId, item);
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, null);
            size--;
        }
    }
}