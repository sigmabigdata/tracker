package ru.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ItemAscByNameTest {

    @Test
    void whenAskByNameIsTrue() {
        List<Item> items = new ArrayList<>();
        Item fox = new Item("dog");
        Item dog = new Item("fox");
        Item wolf = new Item("wolf");
        items.add(dog);
        items.add(fox);
        items.add(wolf);
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(fox);
        expected.add(dog);
        expected.add(wolf);
        assertEquals(items, expected);
    }
}