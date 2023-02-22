package leetcode.greedyalgorithm;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int havePrice = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            // 遇到更便宜的价格直接换
            if (havePrice > prices[i]) {
                havePrice = prices[i];
            } else {
                // 比持有的价格高就买了
                // 吃到这个波段的利益后从这个点作为起点再开始
                res += prices[i] - havePrice;
                havePrice = prices[i];
            }
        }

        return res;
    }
}
