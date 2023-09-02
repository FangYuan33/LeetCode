package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            while (!deque.isEmpty() && i - k >= deque.peekFirst()) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }

        return res;
    }
}
