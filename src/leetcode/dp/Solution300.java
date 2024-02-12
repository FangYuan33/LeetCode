package leetcode.dp;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        // base case 1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
