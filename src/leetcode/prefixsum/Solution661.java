package leetcode.prefixsum;

public class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        // 创建一个二维前缀和数组把它包起来
        int[][] sum = new int[img.length + 2][img[0].length + 2];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] += img[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                // 左上角
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                // 右下角
                int c = Math.min(res.length - 1, i + 1), d = Math.min(res[0].length - 1, j + 1);
                int num = (c - a + 1) * (d - b + 1);

                res[i][j] = sum[c + 1][d + 1] - sum[c + 1][b] - sum[a][d + 1] + sum[a][b];
                res[i][j] /= num;
            }
        }

        return res;
    }
}
