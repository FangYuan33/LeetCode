package leetcode.stackqueuedeap.stack;

import java.util.Stack;

public class Solution42 {
    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        // 维护单调递减栈，遇到比当前值大的才能接到雨水
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            // 遇到高的则需要计算水的面积
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                // 当前洼地索引
                int curIndex = stack.pop();
                // 特殊情况
                if (stack.isEmpty()) {
                    continue;
                }

                // 左索引
                int left = stack.peek();
                // 右索引
                int right = i;
                // 计算面积的高度 = 左右高度小值 - 当前洼地高度
                int h = Math.min(height[left], height[right]) - height[curIndex];
                // 宽度
                int w = right - left - 1;

                res += h * w;
            }
            stack.push(i);
        }

        return res;
    }
}
