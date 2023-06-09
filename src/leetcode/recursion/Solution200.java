package leetcode.recursion;

public class Solution200 {
    /**
     * 对整个矩阵都进行遍历，如果遇到了岛屿，那么把这块岛屿通过递归来变成海洋
     * 这就可以在之后遍历的时候保证不会重复统计
     */
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    // 清除该岛屿
                    recursion(grid, i, j);
                }
            }
        }

        return res;
    }

    private void recursion(char[][] grid, int row, int column) {
        // 结束条件 越界、遇到海洋
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length
                || grid[row][column] == '0') {
            return;
        }

        // 陆地变海洋
        grid[row][column] = '0';

        // 上下左右递归
        recursion(grid, row + 1, column);
        recursion(grid, row - 1, column);
        recursion(grid, row, column + 1);
        recursion(grid, row, column - 1);
    }
}
