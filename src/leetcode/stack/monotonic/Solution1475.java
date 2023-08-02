package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution1475 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1475().finalPrices(new int[] {8,4,6,2,3})));;
    }

    public int[] finalPrices(int[] prices) {
        // 单调递增栈找最近的小值
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                // 商品价格的index，当前 i 为折扣值
                Integer index = stack.pop();
                // 计算价格
                res[index] = prices[index] - prices[i];
            }

            // 价格索引入栈
            stack.push(i);
        }
        // 没有折扣的需要等于原价处理
        while (!stack.isEmpty()) {
            res[stack.peek()] = prices[stack.pop()];
        }

        return res;
    }
}
