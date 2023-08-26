package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        // 记录对应前缀和的数量
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(preSum, 1);

        int res = 0;
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
