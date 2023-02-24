package leetcode.dp;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        // base case 第一行 第一列累加 单词转成空串
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int j = 1; j <= word1.length(); j++) {
            dp[j][0] = j;
        }

        // 相等的话取对角线，不等取上左斜最小值 + 1
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance("ros", "horse"));
    }
}
