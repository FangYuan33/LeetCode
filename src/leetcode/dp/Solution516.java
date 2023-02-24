package leetcode.dp;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        // 回文串问题，取对角线且反向遍历
        int[][] dp = new int[s.length()][s.length()];
        // base case 对角线值为1 代表单个字符串的最长回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // 反向遍历，相等的话 + 2 不等取最大
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
