package leetcode.prefixsum;

public class NumMatrix {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{new int[]{-4, -5}});

        System.out.println(numMatrix.sumRegion(0, 0, 0, 1));
    }

    int[][] sum;

    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        // 初始化二维数组前缀和
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; row2++; col1++; col2++;
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }

}
