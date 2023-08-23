package leetcode.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 实现方法
 *
 * @author FangYuan
 * @since 2023-07-18 20:35:51
 */
public class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (super.containsKey(key)) {
            return super.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
