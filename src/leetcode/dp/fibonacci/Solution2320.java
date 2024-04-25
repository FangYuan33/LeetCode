package leetcode.dp.fibonacci;

public class Solution2320 {

    public static void main(String[] args) {
        System.out.println(new Solution2320().countHousePlacements(1));
    }

    int MOD = (int) (1e9 + 7);

    public int countHousePlacements(int n) {
        long[] dp = new long[n + 2];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 0; i < n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2]
            dp[i + 2] = (dp[i] + dp[i + 1]) % MOD;
        }

        return (int) ((dp[dp.length - 1] * dp[dp.length - 1]) % MOD);
    }
}
