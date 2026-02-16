package leetcode;

import java.util.*;

/**
 * 供本地题解使用
 *
 * @author FangYuan
 * @since 2023-11-14 09:26:23
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

    List<List<String>> res;
    int n;
    boolean[][] memo;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        memo = new boolean[n][n];
        this.n = n;

        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }

        backtrack(chars, 0, new LinkedList<>());

        return res;
    }

    private void backtrack(char[][] chars, int row, LinkedList<String> path) {
        if (path.size() == n) {
            res.add((List<String>) path.clone());
            return;
        }
        if (row >= n) {
            return;
        }

        for (int i = row; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                // 某行某列没有才行
                if (isValid(chars, i, j)) {
                    chars[i][j] = 'Q';

                    StringBuilder element = new StringBuilder();
                    for (char c : chars[row]) {
                        element.append(c);
                    }
                    path.add(element.toString());
                    // 去下一行再找
                    backtrack(chars, i + 1, path);
                    // 恢复现场
                    chars[i][j] = '.';
                    path.removeLast();
                }
            }
        }
    }

    private boolean isValid(char[][] locations, int row, int colum) {
        boolean valid = true;
        // 第一行默认可以放
        if (row == 0) {
            return valid;
        }
        // 检查上一行有没有皇后
        boolean exist = false;
        for (int i = 0; i < locations.length; i++) {
            if (locations[row - 1][i] == 'Q') {
                exist = true;
                break;
            }
        }
        if (!exist) {
            return !valid;
        }
        // 检查同列有没有皇后
        for (int i = 0; i < row; i++) {
            if (locations[i][colum] == 'Q') {
                return !valid;
            }
        }
        // 检查对角线有没有皇后
        int x = 1;
        for (; (row - x >= 0 && colum - x >= 0) || (row - x >= 0 && colum + x < locations.length); x++) {
            if (row - x >= 0 && colum - x >= 0 && locations[row - x][colum - x] == 'Q') {
                return !valid;
            }
            if (row - x >= 0 && colum + x < locations.length && locations[row - x][colum + x] == 'Q') {
                return !valid;
            }
        }
        return valid;
    }
}