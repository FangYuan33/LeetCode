package leetcode.stack.monotonic;

import java.util.*;

public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    static class PriceAndIndex {

        int price;

        int index;

        public PriceAndIndex(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    Stack<PriceAndIndex> stack;

    int index;

    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new PriceAndIndex(Integer.MAX_VALUE, -1));
        index = 0;
    }

    public int next(int price) {
        // 从大到小顺序排列，更高的作为新的停止点，所以是找大值
        while (!stack.isEmpty() && price >= stack.peek().price) {
            stack.pop();
        }
        int res = index - stack.peek().index;
        stack.push(new PriceAndIndex(price, index++));

        return res;
    }
}
