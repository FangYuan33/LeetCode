package leetcode.hashmap;

import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[]{hashMap.get(num), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
