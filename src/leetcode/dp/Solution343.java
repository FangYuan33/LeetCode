package leetcode.dp;

public class Solution343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= n - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }

        return dp[n];
    }
}
