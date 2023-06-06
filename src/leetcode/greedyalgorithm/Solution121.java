package leetcode.greedyalgorithm;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        // 持有价格
        int carry = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < carry) {
                // 价格小则直接变更持有价格
                carry = prices[i];
            } else {
                // 当前价格比持有价格大计算利润
                res = Math.max(res, prices[i] - carry);
            }
        }

        return res;
    }
}
