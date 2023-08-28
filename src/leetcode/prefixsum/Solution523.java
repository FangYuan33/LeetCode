package leetcode.prefixsum;

import java.util.HashMap;

public class Solution523 {

    public static void main(String[] args) {
        System.out.println(new Solution523().checkSubarraySum(new int[]{0, 1, 0, 3, 0, 4, 0, 4, 0}, 5));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // (p[0, i] - p[0, k]) = n * k
        // (p[0, i] - p[0, k]) % k == 0, i >= 2, k <= i - 2;
        // p[0, i] % k == p[0, k] % k
        int preSum = 0;
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        preSum += nums[0];
        if (!sumIndex.containsKey(preSum % k)) {
            sumIndex.put(preSum % k, 0);
        }

        for (int i = 1; i < nums.length; i++) {
            preSum += nums[i];

            if (sumIndex.containsKey(preSum % k)) {
                Integer j = sumIndex.get(preSum % k);
                if (j + 2 <= i) {
                    return true;
                }
            } else {
                sumIndex.put(preSum % k, i);
            }
        }

        return false;
    }
}
