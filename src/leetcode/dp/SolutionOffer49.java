package leetcode.dp;

public class SolutionOffer49 {
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }

        // base case
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // 索引值
        int a2 = 1;
        int b3 = 1;
        int c5 = 1;

        for (int i = 2; i < dp.length; i++) {
            int a = dp[a2] * 2;
            int b = dp[b3] * 3;
            int c = dp[c5] * 5;

            dp[i] = Math.min(a, Math.min(b, c));

            // 是并列的条件，因为可能会重复
            if (dp[i] == a) {
                a2++;
            }
            if (dp[i] == b) {
                b3++;
            }
            if (dp[i] == c) {
                c5++;
            }
        }

        return dp[n];
    }
}
