package leetcode.stack.monotonic;

import java.util.Stack;

public class Solution42 {
    public int trap(int[] height) {
        // 寻找当前位置元素的左右两边高的柱子，使用单调递减栈
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            // 当前元素不只比一个栈内元素大 所以用 while 循环
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 当前值出栈
                Integer cur = stack.pop();
                // 如果左边没有柱子
                if (stack.isEmpty()) {
                    continue;
                }

                // 注意这里的 peek() 条件，而不是 pop 因为它可能作为之后的洼地来使用
                Integer left = stack.peek();
                int w = i - left + 1 - 2;
                // 高度 = 左右小值 - 当前洼地的高度
                int h = Math.min(height[left], height[i]) - height[cur];
                res += w * h;
            }

            stack.push(i);
        }

        return res;
    }
}
