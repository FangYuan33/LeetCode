package leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Interview0812 {

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        char[][] locations = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                locations[i][j] = '.';
            }
        }
        backtrack(locations, 0);
        return res;
    }

    private void backtrack(char[][] locations, int row) {
        if (row == locations.length) {
            LinkedList<String> element = new LinkedList<>();
            for (char[] location : locations) {
                element.add(String.valueOf(location));
            }
            res.add(element);
            return;
        }

        for (int i = 0; i < locations.length; i++) {
            if (isValid(locations, row, i)) {
                locations[row][i] = 'Q';
                backtrack(locations, row + 1);
                locations[row][i] = '.';
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
