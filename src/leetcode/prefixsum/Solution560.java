package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        // 使用 map 标记前缀和出现的次数，即连续子数组的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
