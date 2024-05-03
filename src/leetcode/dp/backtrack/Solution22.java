package leetcode.dp.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution22 {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        backtrack(3, 3, new StringBuilder());
        return res;
    }

    // 1. 当前问题：拼接第 i 个括号
    // 2. 每一步的操作：根据条件判断拼接左、右括号
    // 3. 子问题：拼接第 i + 1 个括号
    private void backtrack(int left, int right, StringBuilder path) {
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }

        if (left > 0) {
            path.append("(");
            backtrack(left - 1, right, path);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
        }
        if (right > left) {
            path.append(")");
            backtrack(left, right - 1, path);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
        }
    }
}
