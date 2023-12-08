package leetcode.hashmap;

import java.util.*;

public class RandomizedSet {
    HashMap<Integer, Integer> valIndex;

    int[] nums;

    int index;

    Random random;

    public RandomizedSet() {
        this.valIndex = new HashMap<>();
        this.nums = new int[200001];
        this.index = 0;
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (valIndex.containsKey(val)) {
            return false;
        } else {
            nums[index] = val;
            valIndex.put(val, index++);
            return true;
        }
    }

    public boolean remove(int val) {
        if (valIndex.containsKey(val)) {
            Integer originIndex = valIndex.remove(val);
            if (originIndex != index - 1) {
                nums[originIndex] = nums[index - 1];
                valIndex.put(nums[index - 1], originIndex);
            }
            index--;
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return nums[random.nextInt(index)];
    }
}
