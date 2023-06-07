package leetcode.greedyalgorithm;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        // 持有价格
        int carry = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (carry <= prices[i]) {
                // 持有价格低来获取利润
                res += (prices[i] - carry);
            }
            // 持有价格高或者每次计算完利润后都要变更持有价格
            carry = prices[i];
        }

        return res;
    }
}
