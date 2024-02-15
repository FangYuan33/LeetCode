package leetcode.dp.backtrack;

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                locations[i][j] = '.';
            }
        }

        backtrack(locations, 0);

        return res;
    }

    private void backtrack(char[][] locations, int row) {
        // 结束条件：遍历到了最后一行
        if (row == n) {
            // 把棋盘的每行都拿出来初始化该答案
            ArrayList<String> element = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                element.add(String.valueOf(locations[i]));
            }

            res.add(element);

            return;
        }

        // 开始在棋盘上做选择，放皇后还是不放皇后
        for (int j = 0; j < n; j++) {
            // 能放的话则放皇后
            if (isValid(locations, row, j)) {
                locations[row][j] = 'Q';

                // 继续向下一行看能不能放皇后
                backtrack(locations, row + 1);

                // 回溯完了需要把该位置的皇后拿掉
                locations[row][j] = '.';
            }
        }
    }

    // 判断是否能放皇后
    private boolean isValid(char[][] locations, int row, int colume) {
        // 先判断上一行是否有皇后，没皇后直接false，第一行开始放默认有皇后
        if (row == 0) {
            return true;
        }
        boolean exist = false;
        for (int j = 0; j < n; j++) {
            if (locations[row - 1][j] == 'Q') {
                exist = true;
                break;
            }
        }
        if (!exist) {
            return false;
        }

        // 判断同列上有没有皇后
        for (int i = row - 1; i >= 0; i--) {
            if (locations[i][colume] == 'Q') {
                return false;
            }
        }
        // 判断对角线上有没有皇后，指定 x 为偏移量
        int x = 1;
        for (int i = row - 1; i >= 0; i--, x++) {
            if (colume + x < n && locations[i][colume + x] == 'Q') {
                return false;
            }
            if (colume - x >= 0 && locations[i][colume - x] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0812().solveNQueens(4));
    }
}
