package leetcode.dp;

public class Solution1312 {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];

        // 不断的从子串计算转换成回文串的开销
        for (int subLength = 2; subLength <= s.length(); subLength++) {
            for (int i = 0, j = subLength - 1; j < s.length(); i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // i和j分别为子串最两边的两个元素，dp[i + 1][j - 1] 表示它们的子回文串
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // dp[i][j - 1] 和 dp[i + 1][j] 分别表示两个子串转换成回文串的开销
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
