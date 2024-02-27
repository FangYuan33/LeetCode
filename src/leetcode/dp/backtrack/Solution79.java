package leetcode.dp.backtrack;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '-';
        boolean res = backtrack(board, i + 1, j, word, k + 1) || backtrack(board, i - 1, j, word, k + 1)
                || backtrack(board, i, j + 1, word, k + 1) || backtrack(board, i, j - 1, word, k + 1);
        board[i][j] = temp;

        return res;
    }
}
