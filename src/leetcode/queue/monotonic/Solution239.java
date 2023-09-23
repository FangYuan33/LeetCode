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
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(right);

            if (right - left + 1 == k) {
                res[index++] = nums[deque.peekFirst()];
                if (left == deque.peekFirst()) {
                    deque.pollFirst();
                }
                left++;
            }

            right++;
        }

        return res;
    }
}
