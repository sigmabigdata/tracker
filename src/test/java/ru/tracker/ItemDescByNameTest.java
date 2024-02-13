package ru.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemDescByNameTest {

    @Test
    void whenDeskByNameIsTrue() {
        List<Item> items = new ArrayList<>();
        Item fox = new Item("dog");
        Item dog = new Item("fox");
        Item wolf = new Item("wolf");
        items.add(fox);
        items.add(dog);
        items.add(wolf);
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(wolf);
        expected.add(dog);
        expected.add(fox);
        assertEquals(items, expected);
    }
}