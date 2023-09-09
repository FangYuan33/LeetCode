package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution84 {

    public static void main(String[] args) {
        System.out.println(new Solution84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }
}
