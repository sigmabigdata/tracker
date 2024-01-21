package ru.tracker;

public final class SingleTracker {

    private Tracker tracker = new Tracker();
    private static SingleTracker instance;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {

        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(item.getId(), item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}