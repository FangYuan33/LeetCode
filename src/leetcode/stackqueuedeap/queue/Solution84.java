package leetcode.stackqueuedeap.queue;

import java.util.*;

public class Solution84 {
    public static void main(String[] args) {
        System.out.println(new Solution84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        // 当前矩形的面积是向左和向右分别找到第一个小于当前柱子的值
        int res = 0;

        // 两侧哨兵，为了计算左边界和右边界
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, newHeights.length - 2);

        // 单调递增栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeights.length; i++) {
            // 遇到比当前柱子小的值那么就是它的右边界
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                // 栈顶元素即为当前矩形的高度
                int height = newHeights[stack.pop()];
                // 左边界索引
                int left = stack.peek() + 1;
                // 右边界索引
                int right = i - 1;

                res = Math.max(res, (right - left + 1) * height);
            }
            stack.push(i);
        }

        return res;
    }
}
