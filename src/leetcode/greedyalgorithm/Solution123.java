package leetcode.greedyalgorithm;

public class Solution123 {

    /**
     * 第二组交易减去了第一组交易的利润，那么第二组交易一定都是在第一组交易之后做的
     * 并没有累加计算是因为题目要求只能做两次交易
     */
    public int maxProfit(int[] prices) {
        // 定义两组交易
        int carry1 = prices[0], profit1 = 0;
        int carry2 = prices[0], profit2 = 0;

        for (int i = 1; i < prices.length; i++) {
            if (carry1 > prices[i]) {
                // 持有价格大则换成小的价格
                carry1 = prices[i];
            } else {
                // 否则计算利润，持有价格不变
                profit1 = Math.max(profit1, prices[i] - carry1);
            }

            // 第二组交易持有价格减去第一组的利润，那么这样第二组交易就是在第一组交易基础上开始的
            // 在保证了第二次交易在第一次交易之前，再取第二次交易的持有价格最小值就能拿到某一次第二次交易的持有的最小价格
            // 当某次循环遍历到这的时候，能计算到第二次交易与之后的股价的计算结果，也就是总利润
            carry2 = Math.min(carry2, prices[i] - profit1);
            // 计算利润保存最大值
            profit2 = Math.max(profit2, prices[i] - carry2);
        }

        return profit2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
