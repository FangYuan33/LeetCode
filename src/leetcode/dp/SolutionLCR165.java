package leetcode.dp;

public class SolutionLCR165 {
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (10 <= num && num <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[s.length()];
    }
}
