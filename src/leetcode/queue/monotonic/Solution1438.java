package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1438 {

    public static void main(String[] args) {
        System.out.println(new Solution1438().longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4));
    }

    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> max = new ArrayDeque<>();
        ArrayDeque<Integer> min = new ArrayDeque<>();

        int res = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (!max.isEmpty() && nums[right] > nums[max.peekLast()]) {
                max.pollLast();
            }
            max.addLast(right);
            while (!min.isEmpty() && nums[right] < nums[min.peekLast()]) {
                min.pollLast();
            }
            min.addLast(right);

            while (!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > limit && left < right) {
                if (left == max.peekFirst()) {
                    max.pollFirst();
                }
                if (left == min.peekFirst()) {
                    min.pollFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
