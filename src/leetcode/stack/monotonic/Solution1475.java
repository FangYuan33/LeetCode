package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution1475 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1475().finalPrices(new int[]{8, 4, 6, 2, 3})));
        ;
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }
}
