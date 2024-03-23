package leetcode.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution1673 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1673().mostCompetitive(
                new int[]{84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71},
                24)));
    }

    /**
     * 如果能抽象想到单调栈法其实就不难了，结合题目不难发现：
     * 如果出现能够保证 K 长度且较小的元素，都能将栈中的元素挤走
     */
    public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && k < (nums.length - i + stack.size()) && nums[i] < stack.peekLast()) {
                stack.pollLast();
            }
            stack.offer(nums[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollFirst();
        }

        return res;
    }

}
