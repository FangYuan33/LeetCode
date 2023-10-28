package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Solution215 {

    public static void main(String[] args) {
        System.out.println(new Solution215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
            } else {
                if (num > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }

        return priorityQueue.peek();
    }
}
