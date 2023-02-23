package leetcode.recursion;

public class SolutionOffer12 {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recursion(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recursion(char[][] board, int row , int column, boolean[][] visited, String word, int n) {
        // 结束条件 越界 不等 已经找过的节点
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || board[row][column] != word.charAt(n) || visited[row][column]) {
            return false;
        }
        // 成功条件
        if (n == word.length() - 1) {
            return true;
        }

        // 避免找重复
        visited[row][column] = true;

        // 四面八方去找，找到一个就算成功
        boolean res1 = recursion(board, row + 1, column, visited, word, n + 1);
        boolean res2 = recursion(board, row - 1, column, visited, word, n + 1);
        boolean res3 = recursion(board, row, column + 1, visited, word, n + 1);
        boolean res4 = recursion(board, row, column - 1, visited, word, n + 1);

        visited[row][column] = false;

        return res1 || res2 || res3 || res4;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer12().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
