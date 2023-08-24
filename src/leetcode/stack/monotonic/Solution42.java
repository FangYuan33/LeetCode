package leetcode.stack.monotonic;

import java.util.Stack;

public class Solution42 {

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public int trap(int[] height) {
        // 单调递减栈找高的值
        Stack<Integer> max = new Stack<>();

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!max.isEmpty() && height[i] > height[max.peek()]) {
                Integer mid = max.pop();
                // 如果存在柱子才能继续计算面积
                if (!max.isEmpty()) {
                    // 宽度
                    int w = i - max.peek() - 1;
                    // 高度取小高度并减去洼地的高度
                    int h = Math.min(height[i], height[max.peek()]);
                    h -= height[mid];

                    res += w * h;
                }
            }
            max.push(i);
        }

        return res;
    }
}
