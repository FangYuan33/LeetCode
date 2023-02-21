package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution0812 {

    List<List<String>> res;
    int n;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        this.n = n;

        // 初始化棋盘
        char[][] locations = new char[n][n];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[0].length; j++) {
                locations[i][j] = '.';
            }
        }
        // 执行回溯
        backtrack(locations, 0);

        return res;
    }

    // rowNum正要选择的行数
    private void backtrack(char[][] locations, int rowNum) {
        // 结束条件: 遍历完最后一行
        if (rowNum == n) {
            List<String> element = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                element.add(new String(locations[j]));
            }
            res.add(element);

            return;
        }

        // 在每行中选皇后的位置
        for (int i = 0; i < n; i++) {
            // 该位置选皇后还是不选皇后
            if (isValid(locations, rowNum, i)) {
                locations[rowNum][i] = 'Q';
                backtrack(locations, rowNum + 1);
                // 回溯完该行的这个位置选择后，将其重置成"."
                locations[rowNum][i] = '.';
            }
            // 不选皇后不再向下执行
        }
    }

    // 判断该位置是否能放置皇后
    private boolean isValid(char[][] locations, int row, int column) {
        // 校验上一行有皇后
        boolean flag = false;
        if (row == 0) {
            flag = true;
        }
        for (int i = 0; i < n && row >= 1; i++) {
            if (locations[row - 1][i] == 'Q') {
                flag = true;
                break;
            }
        }

        // 校验同列不能有皇后
        for (int i = row - 1; i >= 0; i--) {
            if (locations[i][column] == 'Q') {
                return false;
            }
        }

        // 校验对角线不能有皇后
        // 列的偏移量
        int x = 1;
        for (int i = row - 1; i >= 0; i--, x++) {
            if (column - x >= 0 && locations[i][column - x] == 'Q') {
                return false;
            }
            if (column + x <= n - 1 && locations[i][column + x] == 'Q') {
                return false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0812().solveNQueens(4));
    }
}
