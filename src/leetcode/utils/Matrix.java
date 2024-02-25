package leetcode.utils;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Matrix.convert("[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]")));
    }

    /**
     * 将字符串转换为 2 维数组
     * eg: [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]
     */
    public static int[][] convert(String s) {
        String[] elements = s.substring(1, s.length() - 1).split("],");
        int[][] twoDimensionalArray = new int[elements.length][2];
        for (int i = 0; i < elements.length; i++) {
            // 去除方括号
            String pair = elements[i].replace("[", "").replace("]", "");
            // 按 "," 分割字符串
            String[] nums = pair.split(",");
            twoDimensionalArray[i][0] = Integer.parseInt(nums[0]);
            twoDimensionalArray[i][1] = Integer.parseInt(nums[1]);
        }

        return twoDimensionalArray;
    }
}
