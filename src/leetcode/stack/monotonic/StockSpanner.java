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
        index = -1;
        stack.push(new PriceAndIndex(Integer.MAX_VALUE, index++));
    }

    public int next(int price) {
        while (!stack.isEmpty() && price >= stack.peek().price) {
            stack.pop();
        }
        PriceAndIndex peek = stack.peek();
        int res = index - peek.index;
        stack.push(new PriceAndIndex(price, index++));

        return res;
    }
}
