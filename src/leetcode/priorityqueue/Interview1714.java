package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Interview1714 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(arr[i]);
            } else {
                if (arr[i] < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll();
        }

        return res;
    }

}
