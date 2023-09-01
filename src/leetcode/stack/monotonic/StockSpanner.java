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

    Stack<PriceAndIndex> priceAndIndices;

    int index;

    public StockSpanner() {
        index = 0;
        priceAndIndices = new Stack<>();
        priceAndIndices.push(new PriceAndIndex(Integer.MAX_VALUE, -1));
    }

    public int next(int price) {
        while (!priceAndIndices.isEmpty() && price >= priceAndIndices.peek().price) {
            priceAndIndices.pop();
        }
        PriceAndIndex newElement = new PriceAndIndex(price, index++);
        int res = newElement.index - priceAndIndices.peek().index;
        priceAndIndices.push(newElement);

        return res;
    }
}
