package leetcode;

import java.util.Arrays;
import java.util.List;

public class Solution213 {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        int max1 = dp[nums.length - 1];

        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int max2 = dp[nums.length - 1];

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] arrays = new int[] {2, 3, 2};

        System.out.println(rob(arrays));
    }
}
