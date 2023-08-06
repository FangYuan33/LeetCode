package leetcode.stack.monotonic;

import java.util.Stack;

public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
    }

    private Stack<PriceAndIndex> stack;

    private int index;

    static class PriceAndIndex {

        int price;

        int index;

        public PriceAndIndex(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    public StockSpanner() {
        stack = new Stack<>();
        // 哨兵节点
        stack.push(new PriceAndIndex(Integer.MAX_VALUE, -1));
        index = 0;
    }

    public int next(int price) {
        // 单调递减栈
        while (!stack.isEmpty() && price >= stack.peek().price) {
            stack.pop();
        }

        int res = index - stack.peek().index;
        stack.push(new PriceAndIndex(price, index++));

        return res;
    }
}
