package leetcode.prefixsum;

import java.util.HashMap;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        // 计算前缀和，并把 0 转换为 -1 来求解，这样符合题意的区间和为 0
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        // 使用 map 来记录前缀和对应的最小的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        // 如果我们能在 map 中找到相同的前缀和，那么这个序列减去之前出现的序列即为 0 和 1 相等的连续子数组
        int res = 0;
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
