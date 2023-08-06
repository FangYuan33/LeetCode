package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution85 {

    public static void main(String[] args) {
        System.out.println(new Solution85().maximalRectangle(new char[][]{new char[]{'1', '0', '1', '0', '0'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        // 以每行为基准，将 matrix 转换成每列连续 1 的个数，那么这样就转换成了 84 题求矩阵的面积
        int[][] heights = new int[matrix.length][matrix[0].length];
        // 初始化第一行
        for (int i = 0; i < matrix[0].length; i++) {
            heights[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[i][j] = matrix[i][j] == '1' ?  (heights[i - 1][j] + 1) : 0;
            }
        }

        int res = 0;
        // 遍历每行
        for (int[] height : heights) {
            // 单调递增站找当前值左右两边最小的柱子
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[height.length];
            Arrays.fill(left, -1);
            int[] right = new int[height.length];
            Arrays.fill(right, right.length);

            // 正序统计右小值
            for (int j = 0; j < height.length; j++) {
                while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
                    right[stack.pop()] = j;
                }
                stack.push(j);
            }
            stack.clear();
            // 倒序统计左小值
            for (int j = height.length - 1; j >= 0; j--) {
                while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
                    left[stack.pop()] = j;
                }
                stack.push(j);
            }

            for (int j = 0; j < height.length; j++) {
                res = Math.max(res, (right[j] - left[j] - 1) * height[j]);
            }
        }

        return res;
    }
}
