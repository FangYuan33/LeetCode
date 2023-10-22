package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class SolutionLCR159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] res = new int[cnt];
        if (cnt == 0) {
            return res;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int s : stock) {
            if (priorityQueue.size() < cnt) {
                priorityQueue.offer(s);
            } else {
                if (s < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(s);
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll();
        }

        return res;
    }
}
