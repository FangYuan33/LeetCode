package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;

        // 计算前缀和
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 统计前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 1; i < preSum.length; i++) {
            // 检查这个前缀和有没有在所有前缀和中出现过，如果有累加次数
            int sum = preSum[i] - k;
            res += map.getOrDefault(sum, 0);
            // 把这个前缀和统计进去
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        return res;
    }
}
