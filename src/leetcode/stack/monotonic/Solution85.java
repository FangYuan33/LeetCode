package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution85 {

    public static void main(String[] args) {
        System.out.println(new Solution85().maximalRectangle(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[0].length; j++) {
                intMatrix[i][j] = matrix[i][j] - '0';
            }
        }

        int res = 0;
        // 计算出第一行的面积
        int temp = 0;
        for (int i = 0; i < intMatrix[0].length; i++) {
            if (intMatrix[0][i] == 1) {
                temp++;
            } else {
                temp = 0;
            }
            res = Math.max(res, temp);
        }

        // 从第二行开始不断的构造矩形，如果当前行是 1 的话，累加上边的，否则的话为 0 不变
        for (int i = 1; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[0].length; j++) {
                if (intMatrix[i][j] == 1) {
                    intMatrix[i][j] += intMatrix[i - 1][j];
                }
            }
            // 矩形构造完了，使用单调递增栈遇到小值时记录当前矩形左右最早的高度
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[intMatrix[0].length];
            Arrays.fill(left, -1);
            int[] right = new int[intMatrix[0].length];
            Arrays.fill(right, intMatrix[0].length);

            // 正序找右
            for (int k = 0; k < intMatrix[0].length; k++) {
                while (!stack.isEmpty() && intMatrix[i][k] < intMatrix[i][stack.peek()]) {
                    right[stack.pop()] = k;
                }
                stack.push(k);
            }
            stack.clear();
            // 倒序找左
            for (int k = intMatrix[0].length - 1; k >= 0; k--) {
                while (!stack.isEmpty() && intMatrix[i][k] < intMatrix[i][stack.peek()]) {
                    left[stack.pop()] = k;
                }
                stack.push(k);
            }

            // 计算面积
            for (int k = 0; k < intMatrix[0].length; k++) {
                res = Math.max(res, (right[k] - left[k] - 1) * intMatrix[i][k]);
            }
        }

        return res;
    }
}
