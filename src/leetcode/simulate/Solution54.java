package leetcode.simulate;

import java.util.LinkedList;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {
        System.out.println(new Solution54().spiralOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        boolean rowRight = true, rowLeft = false;
        boolean columnDown = false, columnUp = false;
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int columnBegin = 0, columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            if (rowRight) {
                int index = columnBegin;
                while (index <= columnEnd) {
                    res.add(matrix[rowBegin][index++]);
                }
                rowBegin++;
                rowRight = false;
                columnDown = true;
                continue;
            }
            if (columnDown) {
                int index = rowBegin;
                while (index <= rowEnd) {
                    res.add(matrix[index++][columnEnd]);
                }
                columnEnd--;
                columnDown = false;
                rowLeft = true;
                continue;
            }
            if (rowLeft) {
                int index = columnEnd;
                while (index >= columnBegin) {
                    res.add(matrix[rowEnd][index--]);
                }
                rowEnd--;
                rowLeft = false;
                columnUp = true;
                continue;
            }
            if (columnUp) {
                int index = rowEnd;
                while (index >= rowBegin) {
                    res.add(matrix[index--][columnBegin]);
                }
                columnBegin++;
                columnUp = false;
                rowRight = true;
            }
        }

        return res;
    }
}
