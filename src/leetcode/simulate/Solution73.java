package leetcode.simulate;

import leetcode.utils.Matrix;

import java.util.HashSet;

public class Solution73 {

    public static void main(String[] args) {
        new Solution73().setZeroes(Matrix.convert("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]"));
    }

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> setM = new HashSet<>();
        HashSet<Integer> setN = new HashSet<>();

        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[0].length; n++) {
                // 行列
                if (matrix[m][n] == 0) {
                    setM.add(m);
                    setN.add(n);
                }
            }
        }

        // 处理行
        for (int m = 0; m < matrix.length; m++) {
            if (setM.contains(m)) {
                int n = 0;
                while (n < matrix[0].length) {
                    matrix[m][n] = 0;
                    n++;
                }
            }
        }
        // 处理列
        for (int n = 0; n < matrix[0].length; n++) {
            if (setN.contains(n)) {
                int m = 0;
                while (m < matrix.length) {
                    matrix[m][n] = 0;
                    m++;
                }
            }
        }
    }
}
