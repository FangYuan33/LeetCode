package leetcode.dp;

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            int a1 = dp[a] * 2;
            int b1 = dp[b] * 3;
            int c1 = dp[c] * 5;
            dp[i] = Math.min(a1, Math.min(b1, c1));
            if (a1 == dp[i]) {
                a++;
            }
            if (b1 == dp[i]) {
                b++;
            }
            if (c1 == dp[i]) {
                c++;
            }
        }

        return dp[n];
    }
}
