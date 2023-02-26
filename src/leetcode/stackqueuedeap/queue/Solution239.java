package leetcode.stackqueuedeap.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 单调队列实现
        Deque<Integer> deque = new LinkedList<>();

        // 初始化第一个窗口值
        for (int i = 0; i < k; i++) {
            addElement(deque, nums[i]);
        }
        res[0] = deque.peekFirst();

        int index = 1;
        for (int i = k; i < nums.length; i++) {
            // 判断是否需要移除
            if (nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }

            addElement(deque, nums[i]);

            res[index++] = deque.peekFirst();
        }

        return res;
    }

    private void addElement(Deque<Integer> deque, int num) {
        if (deque.isEmpty()) {
            deque.offer(num);
        } else {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.removeLast();
            }
            deque.offer(num);
        }
    }
}
