package leetcode.prefixsum;

import java.util.HashMap;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        int res = 0;

        // 前缀和
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i < preSum.length; i++) {
            if (map.containsKey(preSum[i])) {
                res = Math.max(res, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }

        return res;
    }
}
