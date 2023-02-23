package leetcode.dp;

public class SolutionOffer47 {
    public int maxValue(int[][] grid) {
        // base case 初始化第一行和第一列
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int j = 1; j < grid.length; j++) {
            grid[j][0] += grid[j - 1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
