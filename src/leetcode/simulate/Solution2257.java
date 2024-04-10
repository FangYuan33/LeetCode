package leetcode.simulate;

public class Solution2257 {

    private static final int[][] dirs = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 墙和警卫标记为 -1 警卫视线所过的点标记为1 最终统计 0
        int[][] matrix = new int[m][n];
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = -1;
        }
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = -1;
        }

        int res = m * n - guards.length - walls.length;
        for (int[] guard : guards) {
            // 4 个方向遍历
            for (int[] dir : dirs) {
                int row = guard[0] + dir[0], col = guard[1] + dir[1];
                while (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] != -1) {
                    if (matrix[row][col] == 0) {
                        res--;
                    }
                    matrix[row][col] = 1;
                    row += dir[0];
                    col += dir[1];
                }
            }
        }

        return res;
    }
}
