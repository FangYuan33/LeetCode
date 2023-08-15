package leetcode.dp;

import java.util.Arrays;

public class Solution637 {

    public static void main(String[] args) {
        System.out.println(new Solution637().findNumberOfLIS(new int[]{1, 3, 2, 5, 4, 7}));
    }

    public int findNumberOfLIS(int[] nums) {
        // base case 是每个值都可以作为长度为 1 的递增子序列，dp 的每个值表示以该位置数形成的最长的子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // 表示以某个值为结尾的最长上升子序列的个数
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, 1);

        // 记录最大的长度
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        // 遇到大的重置计数
                        dp2[i] = dp2[j];
                    } else if (dp[i] == dp[j] + 1) {
                        // 遇到相等的累加
                        dp2[i] += dp2[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max == dp[i]) {
                res += dp2[i];
            }
        }

        return res;
    }
}
