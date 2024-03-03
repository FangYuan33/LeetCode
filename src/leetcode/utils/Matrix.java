package leetcode.utils;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Matrix.convert("[[1,2,2],[1,1,0],[0,1,0]]")));
    }

    /**
     * 将字符串转换为 2 维数组
     * eg: [[1,2,2],[1,1,0],[0,1,0]]
     */
    public static int[][] convert(String s) {
        String[] elements = s.substring(1, s.length() - 1).split("],");
        int n = elements.length;
        int m = elements[0].split(",").length;
        int[][] twoDimensionalArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            // 去除方括号
            String row = elements[i].replace("[", "").replace("]", "");
            // 按 "," 分割字符串
            String[] nums = row.split(",");
            for (int j = 0; j < m; j++) {
                twoDimensionalArray[i][j] = Integer.parseInt(nums[j]);
            }
        }
        return twoDimensionalArray;
    }
}
