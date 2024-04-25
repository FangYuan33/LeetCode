package leetcode.dp.fibonacci;

public class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            // 偷 / 不偷
            dp[i + 2] = Math.max(nums[i] + dp[i], dp[i + 1]);
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
