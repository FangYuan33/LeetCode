package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution84 {

    public static void main(String[] args) {
        System.out.println(new Solution84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        // 单调栈递增栈，遇到小值的话则需要记录当前柱子的左/右端点，这样找到了左右端点的宽度极限就能发挥这个柱子的最大面积
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);

        // 正序遍历找右边
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        // 倒序找左边
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max((right[i] - left[i] - 1) * heights[i], res);
        }

        return res;
    }
}
