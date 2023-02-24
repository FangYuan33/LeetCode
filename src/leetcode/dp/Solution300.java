package leetcode.dp;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        // base case 每个数的初始自增序列都是1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        // 每个dp数表示当前数的最长序列 如果之后有数比这个大 那么就累加
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
