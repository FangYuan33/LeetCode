package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        // 单调递减队列 找大值
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);

            // 先满足窗口大小
            if (i + 1 < k) {
                continue;
            }
            // 判断队列头元素的最大值是不是窗口即将划过的值
            if (i - k >= 0) {
                if (nums[deque.peek()] == nums[i - k]) {
                    deque.poll();
                }
            }

            // 封装结果
            res[index++] = nums[deque.peek()];
        }

        return res;
    }
}
