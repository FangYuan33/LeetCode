package leetcode.dp;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // base case 值为 0，表示字符串无子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 相等取对角线值（相等字符串长度）加一
        // 不等则取上、左最大值
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
