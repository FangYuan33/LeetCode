package leetcode.dp;

public class Solution1312 {
    public int minInsertions(String s) {
        // 回文串，对角线，反向遍历
        int[][] dp = new int[s.length()][s.length()];
        // base case 对角线为0 无需操作

        // 相等的话取子串值，无需操作；不等取子串小值 + 1
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
