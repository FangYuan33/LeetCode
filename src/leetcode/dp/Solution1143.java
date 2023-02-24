package leetcode.dp;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 无 base case
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 相等去对角线加一，对角线表示两字符串在最长子序列上都增加一个相同字符后的结果
        // 不等的话 取上左最大值，不做加一操作，因为没相等...
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
