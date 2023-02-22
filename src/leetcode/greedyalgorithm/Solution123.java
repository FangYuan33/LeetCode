package leetcode.greedyalgorithm;

public class Solution123 {
    public int maxProfit(int[] prices) {
        // 定义两组交易
        int buy1 = prices[0], profit1 = 0;
        int buy2 = prices[0], profit2 = 0;

        for (int i = 1; i < prices.length; i++) {
            // 第一组交易
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buy1);
            // 第二组交易的买入价格减去第一组交易的利润
            // 那么这样第二组交易就包含了第一组交易的利润
            buy2 = Math.min(buy2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - buy2);
        }

        return profit2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution123().maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }
}
