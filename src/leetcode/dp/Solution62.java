package dp;

import java.util.Arrays;

public class Solution62 {

    // 1 1 1
    // 1 2 3
    // 1 3 6
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        // 第一行、第一列全部为 1
        for (int i = 0; i < path.length; i++) {
            path[i][0] = 1;
        }
        Arrays.fill(path[0], 1);

        for (int i = 1; i < path.length; i++) {
            for (int j = 1; j < path[0].length; j++) {
                path[i][j] = Math.max(path[i][j], path[i - 1][j] + path[i][j - 1]);
            }
        }

        return path[m - 1][n - 1];
    }
}
