package ru.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


class ItemAscByNameTest {

    @Test
    void whenAskByNameIsTrue() {
        List<Item> items = new ArrayList<>();
        Item fox = new Item("Fox");
        Item dog = new Item("Dog");
        Item wolf = new Item("Wolf");
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(dog);
        expected.add(fox);
        expected.add(wolf);
        assertThat(items.containsAll(expected));
    }
}