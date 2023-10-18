package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));
    }

    PriorityQueue<Integer> priorityQueue;

    int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            process(num);
        }
    }

    public int add(int val) {
        process(val);
        return priorityQueue.peek();
    }

    private void process(int num) {
        if (priorityQueue.isEmpty() || priorityQueue.size() < k) {
            priorityQueue.offer(num);
        } else {
            if (num >= priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
    }
}
