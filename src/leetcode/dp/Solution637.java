package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;

public class Solution637 {

    public static void main(String[] args) {
        System.out.println(new Solution637().findNumberOfLIS(new int[]{2,2,2,2,2}));
    }

    public int findNumberOfLIS(int[] nums) {
        // base case 是每个值都可以作为长度为 1 的递增子序列，dp 的每个值表示以该位置数形成的最长的子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // 标记以某个值结尾的升序最长子序列的个数
        int[] mark = new int[nums.length];
        Arrays.fill(mark, 1);

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        mark[i] = mark[j];
                    } else if (dp[j] + 1 == nums[i]) {
                        mark[i] += mark[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max == dp[i]) {
                res += mark[i];
            }
        }

        return res;
    }
}
