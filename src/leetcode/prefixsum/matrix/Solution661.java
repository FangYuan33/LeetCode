package leetcode.prefixsum.matrix;

import java.util.Arrays;

public class Solution661 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution661().imageSmoother(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
                new int[]{10, 11, 12}
        })));
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] preSum = new int[img.length + 1][img[0].length + 1];
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }

        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                int up = Math.max(0, i - 1), down = Math.min(i + 1, res.length - 1);
                int left = Math.max(0, j - 1), right = Math.min(res[0].length - 1, j + 1);
                int area = (right - left + 1) * (down - up + 1);

                res[i][j] = (preSum[down + 1][right + 1] - preSum[up][right + 1] - preSum[down + 1][left] + preSum[up][left]) / area;
            }
        }

        return res;
    }
}
