package leetcode.other;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        linkedHashMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            int value = linkedHashMap.get(key);
            makeRecently(key, value);

            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);

            return;
        }

        if (this.size == linkedHashMap.size()) {
            int oldKey = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(oldKey);
        }

        linkedHashMap.put(key, value);
    }

    private void makeRecently(int key, int value) {
        linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
    }
}
