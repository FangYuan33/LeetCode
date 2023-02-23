package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), n, n);

        return res;
    }

    private void backtrack(StringBuilder element, int left, int right) {
        // 结束条件 左右括号都用完了
        if (left == 0 && right == 0) {
            res.add(element.toString());
            return;
        }

        // 做选择，是贴左括号还是贴右括号
        if (left > 0) {
            element.append("(");
            backtrack(element, left - 1, right);
            element.deleteCharAt(element.length() - 1);
        }
        if (right > 0 && right > left) {
            element.append(")");
            backtrack(element, left, right - 1);
            element.deleteCharAt(element.length() - 1);
        }
    }
}
