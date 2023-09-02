package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3, -3, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        // preSum[0, i] - preSum[0, x] = k;
        // preSum[0, i] - k = preSum[0, x]
        int res = 0;
        int preSum = 0;
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(preSum, 1);
        for (int num : nums) {
            preSum += num;
            if (sumCount.containsKey(preSum - k)) {
                res += sumCount.get(preSum - k);
            }

            sumCount.put(preSum, sumCount.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
