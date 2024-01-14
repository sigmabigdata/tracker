package ru.tracker.actions;

import ru.tracker.Input;
import ru.tracker.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
