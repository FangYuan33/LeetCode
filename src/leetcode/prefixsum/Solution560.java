package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution560().subarraySum(new int[]{1, -1, 0}, 0));
        // 2
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumNum = new HashMap<>();
        int preSum = 0;
        preSumNum.put(preSum, 1);
        int res = 0;
        for (int num : nums) {
            preSum += num;
            if (preSumNum.containsKey(preSum - k)) {
                res += preSumNum.get(preSum - k);
            }
            preSumNum.put(preSum, preSumNum.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
