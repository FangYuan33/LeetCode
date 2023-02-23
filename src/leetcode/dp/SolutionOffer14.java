package leetcode.dp;

public class SolutionOffer14 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        // base case
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }

        return dp[n];
    }
}
