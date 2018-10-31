package de.twainsoft.storage;

import java.util.ArrayList;

public class InputStorage {

    private ArrayList<String> storage;

    public InputStorage() {
        this.storage = new ArrayList<>();
    }

    public int getStorageSize() {
        return this.storage.size();
    }

    public void addItem(String item) {
        this.storage.add(item);
    }

    public void removeItem(String item) {
        this.storage.remove(item);
    }

    public boolean containsItem(String item) {
        return this.storage.contains(item);
    }

    public String[] getAllItems() {
        String list[] = new String[this.storage.size()];
        this.storage.toArray(list);

        return list;
    }
}
