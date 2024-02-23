package leetcode.simulate;

import java.util.Arrays;

public class Solution59 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution59().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int val = 1;
        boolean rowRight = true, rowLeft = false;
        boolean columnDown = false, columnUp = false;
        int rowBegin = 0, rowEnd = n - 1;
        int columnBegin = 0, columnEnd = n - 1;
        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            if (rowRight) {
                int index = columnBegin;
                while (index <= columnEnd) {
                    res[rowBegin][index++] = val++;
                }
                rowBegin++;
                rowRight = false;
                columnDown = true;
                continue;
            }
            if (columnDown) {
                int index = rowBegin;
                while (index <= rowEnd) {
                    res[index++][columnEnd] = val++;
                }
                columnEnd--;
                columnDown = false;
                rowLeft = true;
                continue;
            }
            if (rowLeft) {
                int index = columnEnd;
                while (index >= columnBegin) {
                    res[rowEnd][index--] = val++;
                }
                rowEnd--;
                rowLeft = false;
                columnUp = true;
                continue;
            }
            if (columnUp) {
                int index = rowEnd;
                while (index >= rowBegin) {
                    res[index--][columnBegin] = val++;
                }
                columnBegin++;
                columnUp = false;
                rowRight = true;
            }
        }

        return res;
    }
}
