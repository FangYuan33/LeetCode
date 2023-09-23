package leetcode.stack.monotonic;

import java.util.Stack;

public class Solution42 {

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int floor = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]);
                    res += (h - floor) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return res;
    }
}
