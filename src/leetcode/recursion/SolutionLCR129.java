package leetcode.recursion;

public class SolutionLCR129 {
    public boolean wordPuzzle(char[][] grid, String target) {
        boolean exist = true;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (recursion(grid, target,0, i, j, visited)) {
                    return exist;
                }
            }
        }

        return !exist;
    }

    private boolean recursion(char[][] grid, String target, int n, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length
                || visited[row][column] || target.charAt(n) != grid[row][column]) {
            return false;
        }
        if (n == target.length() - 1) {
            return true;
        }

        visited[row][column] = true;
        boolean res = recursion(grid, target, n + 1, row + 1, column, visited)
                || recursion(grid, target, n + 1, row - 1, column, visited)
                || recursion(grid, target, n + 1, row, column + 1, visited)
                || recursion(grid, target, n + 1, row, column - 1, visited);
        visited[row][column] = false;

        return res;
    }
}
