package leetcode.greedyalgorithm;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            // 买入价格大
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                // 买入价格小
                res = Math.max(res, prices[i] - minPrice);
            }
        }

        return res;
    }
}
