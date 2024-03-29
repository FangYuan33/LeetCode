package leetcode.dp;

public class SolutionOffer46 {
    public int translateNum(int num) {
        // 很像斐波那契数列
        String numStr = String.valueOf(num);
        // base case
        int[] dp = new int[numStr.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= numStr.length(); i++) {
            int curNum = Integer.parseInt(numStr.substring(i - 2, i));
            if (curNum >= 10 && curNum <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[numStr.length()];
    }
}
