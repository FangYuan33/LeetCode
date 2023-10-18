package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        into(left, right, nums1);
        into(left, right, nums2);

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    private void into(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int[] nums) {
        for (int num : nums) {
            if (left.size() == right.size()) {
                right.offer(num);
                left.offer(right.poll());
            } else {
                left.offer(num);
                right.offer(left.poll());
            }
        }
    }
}
