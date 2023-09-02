package leetcode.prefixsum.matrix;

public class NumMatrix {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{new int[]{-4, -5}});

        System.out.println(numMatrix.sumRegion(0, 0, 0, 1));
    }

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        return preSum[row2][col2] - preSum[row1 - 1][col2] - preSum[row2][col1 - 1] + preSum[row1 - 1][col1 - 1];
    }

}
