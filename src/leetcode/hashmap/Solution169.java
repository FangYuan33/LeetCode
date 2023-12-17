package leetcode.hashmap;

import java.util.HashMap;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int halfLength = nums.length / 2;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            if (numCount.get(num) > halfLength) {
                return num;
            }
        }

        return -1;
    }
}
