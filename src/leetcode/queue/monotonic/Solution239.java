package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // n - k = 滑动次数
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        // 维护第一个窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        int index = 0;
        res[index++] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {
            if ((i - k) == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);

            res[index++] = nums[deque.peekFirst()];
        }

        return res;
    }
}
