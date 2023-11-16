package leetcode.tree.redblacktree;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPrice {

    HashMap<Integer, Integer> timestampPrice;

    TreeMap<Integer, Integer> priceCount;

    int maxTimestamp;

    public StockPrice() {
        priceCount = new TreeMap<>();
        timestampPrice = new HashMap<>();
        maxTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);

        // 管理价格出现的次数
        Integer originPrice = timestampPrice.getOrDefault(timestamp, -1);
        if (priceCount.containsKey(originPrice)) {
            Integer count = priceCount.get(originPrice);
            if (count == 1) {
                priceCount.remove(originPrice);
            } else if (count > 1) {
                priceCount.put(originPrice, count - 1);
            }
        }

        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
        timestampPrice.put(timestamp, price);
    }

    public int current() {
        return timestampPrice.get(maxTimestamp);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}
