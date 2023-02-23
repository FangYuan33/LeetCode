package leetcode.dp;

public class SolutionOffer49 {
    public int nthUglyNumber(int n) {
        // base case
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            int a2 = dp[a] * 2;
            int b3 = dp[b] * 3;
            int c5 = dp[c] * 5;

            dp[i] = Math.min(a2, Math.min(b3, c5));
            if (dp[i] == a2) {
                a++;
            }
            if (dp[i] == b3) {
                b++;
            }
            if (dp[i] == c5) {
                c++;
            }
        }

        return dp[n];
    }
}
