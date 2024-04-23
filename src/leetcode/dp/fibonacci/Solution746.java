package leetcode.dp.fibonacci;

public class Solution746 {

    public static void main(String[] args) {
        System.out.println(new Solution746().minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[dp.length - 1];
    }
}
