package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class SolutionLCR159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        if (cnt == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < cnt; i++) {
            priorityQueue.add(stock[i]);
        }
        for (int i = cnt; i < stock.length; i++) {
            if (stock[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(stock[i]);
            }
        }

        int[] res = new int[cnt];
        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll();
        }

        return res;
    }
}
