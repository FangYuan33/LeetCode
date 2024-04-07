package leetcode.simulate;

import leetcode.Solution;
import leetcode.utils.Matrix;

import java.util.Arrays;

public class Solution2672 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2672().colorTheArray(11, Matrix.convert("[[3,2],[4,1],[4,2],[2,2],[7,2],[5,1],[9,1],[0,1],[2,1],[2,2],[4,2],[2,2],[8,1],[7,2],[1,2],[6,1],[4,2],[9,2],[8,2],[4,2],[7,2],[0,2],[6,2],[4,1],[0,2],[5,2],[4,2],[8,2],[10,2],[1,2],[4,2],[6,2],[8,1],[7,1]]"))));
    }

    public int[] colorTheArray(int n, int[][] queries) {
        int num = 0;
        // 避免越界
        int[] colors = new int[n + 2];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0] + 1;
            int color = queries[i][1];

            // 已经被染色过去掉颜色
            if (colors[index] > 0) {
                num -= (colors[index] == colors[index + 1] ? 1 : 0) + (colors[index] == colors[index - 1] ? 1 : 0);
            }
            // 染色后比较
            colors[index] = color;
            num += (colors[index] == colors[index + 1] ? 1 : 0) + (colors[index] == colors[index - 1] ? 1 : 0);
            res[i] = num;
        }

        return res;
    }
}
