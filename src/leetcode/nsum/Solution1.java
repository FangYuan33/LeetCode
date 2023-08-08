package leetcode.nsum;

import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // hash 法
        HashMap<Integer, Integer> numIndexMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];

            if (numIndexMap.containsKey(num)) {
                return new int[] {i, numIndexMap.get(num)};
            }

            numIndexMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
