package leetcode.simulate;

public class Solution48 {

    public static void main(String[] args) {
        new Solution48().rotate(new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}});
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            // j 表示每行旋转的索引范围
            for (int j = i; j < n - 1 - i; j++) {
                // 一圈一圈的交换
                int temp = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                int temp2 = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp;
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp2;
            }
        }
    }

}
