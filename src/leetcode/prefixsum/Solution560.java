package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        // 记录对应的前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int res = 0;

        for (int num : nums) {
            preSum += num;
            // 检查先前有没有出现过这个前缀和（子序列）符合题目要求
            res += map.getOrDefault(preSum - k, 0);
            // 记录前缀和出现的次数
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
