package leetcode.priorityqueue;

import leetcode.Solution;

import java.util.PriorityQueue;

public class Solution45 {
    public static void main(String[] args) {
        System.out.println(new Solution45().jump(new int[]{0}));
    }

    public int jump(int[] nums) {
        int res = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        int index = 0;
        int cur = 0;

        while (cur < nums.length - 1) {
            while (index < nums.length && index <= cur) {
                priorityQueue.offer(index + nums[index]);
                index++;
            }
            if (priorityQueue.isEmpty()) {
                break;
            } else {
                Integer feature = priorityQueue.poll();
                cur = feature;
                res++;
            }
        }

        return res;
    }
}
