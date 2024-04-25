package leetcode.dp.fibonacci;

public class Solution2466 {

    public static void main(String[] args) {
        System.out.println(new Solution2466().countGoodStrings(500, 500, 5, 2));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        // dp[i] = dp[i - zero] + dp[i - one];
        long[] dp = new long[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
                dp[i] %= (long) (1e9 + 7);
            }
            if (i - one >= 0) {
                dp[i] += dp[i - one];
                dp[i] %= (long) (1e9 + 7);
            }
        }

        long res = 0;
        for (int i = low; i <= high; i++) {
            res = (long) ((res + dp[i]) % (1e9 + 7));
        }

        return (int) res;
    }

}
