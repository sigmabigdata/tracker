package ru.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void whenDeskByNameIsTrue() {
        List<Item> items = new ArrayList<>();
        Item fox = new Item("Fox");
        Item dog = new Item("Dog");
        Item wolf = new Item("Wolf");
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(wolf);
        expected.add(dog);
        expected.add(fox);
        assertThat(items.containsAll(expected));
    }
}