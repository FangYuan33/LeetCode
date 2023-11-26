package leetcode.stack.monotonic;

import java.util.Stack;

public class Solution42 {

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int floor = height[stack.pop()];
                if (!stack.isEmpty()) {
                    Integer w = i - stack.peek() - 1;
                    Integer h = Math.min(height[stack.peek()], height[i]) - floor;
                    res += w * h;
                }
            }
            stack.push(i);
        }

        return res;
    }
}
