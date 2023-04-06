package leetcode.dp;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        // base case 每个索引对应金额，初始情况大于对应金额即可
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // 初始0为0 表示正好凑齐的都到这个位置，而正好凑齐不需要累加
        dp[0] = 0;

        // 初始化每个金额所需的因硬币数量
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
