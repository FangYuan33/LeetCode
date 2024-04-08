package leetcode.simulate;

import leetcode.utils.Matrix;

public class Solution3025 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution3025().numberOfPairs(Matrix.convert("[[6,2],[4,4],[2,6]]")));
    }

    public int numberOfPairs(int[][] points) {
        int res = 0;
        // 左上角、右下角
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                if (points[j][0] < points[i][0] || points[j][1] > points[i][1]) continue;
                boolean flag = true;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) continue;
                    // 包含就会感到伤心
                    if (contains(points[i], points[j], points[k])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean contains(int[] left, int[] right, int[] point) {
        int xLeft = left[0], xRight = right[0];
        int yUp = left[1], yDown = right[1];
        return xLeft <= point[0] && point[0] <= xRight && yDown <= point[1] && point[1] <= yUp;
    }
}
