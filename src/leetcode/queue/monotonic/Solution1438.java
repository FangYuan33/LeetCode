package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1438 {

    public static void main(String[] args) {
        System.out.println(new Solution1438().longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4));
    }

    public int longestSubarray(int[] nums, int limit) {
        // 滑动窗口 + 两个单调队列的方法，窗口从第一个元素不断扩大，并在两个队列中维护最值
        // 窗口扩大的过程中，不断判断是否符合题目要求，如果不符合要求的话，那么需要将窗口缩小 left++
        // 窗口缩小后，需要把最值队列中已经不在窗口的索引值丢掉，这就需要操作单调队列的头
        // 符合条件的则保存结果的最大值
        int res = 0;
        Deque<Integer> min = new ArrayDeque<>(), max = new ArrayDeque<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (!min.isEmpty() && nums[right] < nums[min.peekLast()]) {
                min.pollLast();
            }
            min.offer(right);
            while (!max.isEmpty() && nums[right] > nums[max.peekLast()]) {
                max.pollLast();
            }
            max.offer(right);

            // 如果不符合条件的话，需要缩小窗口，并且需要让 窗口之外的值出栈
            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                left++;
                while (max.peekFirst() < left) {
                    max.pollFirst();
                }
                while (min.peekFirst() < left) {
                    min.pollFirst();
                }
            }
            // 都符合条件了
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
