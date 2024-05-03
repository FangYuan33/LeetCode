package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {

    public static void main(String[] args) {
        System.out.println(new Solution784().letterCasePermutation("a1b2"));
    }

    List<String> res;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new StringBuilder());
        return res;
    }

    // 当前问题：根据当前索引 i 处的字符构造长为 n 的字符串
    // 每一步操作：判断是否为字母，为字母的话操作大写或小写，否则直接添加上
    // 子问题：根据索引 i + 1 处的字符构造长为 n - 1 的字符串
    private void backtrack(String s, int i, StringBuilder path) {
        if (i == s.length()) {
            res.add(path.toString());
            return;
        }

        char cur = s.charAt(i);
        if (Character.isDigit(cur)) {
            path.append(cur);
            backtrack(s, i + 1, path);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
        } else {
            path.append(Character.toLowerCase(cur));
            backtrack(s, i + 1, path);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
            path.append(Character.toUpperCase(cur));
            backtrack(s, i + 1, path);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
        }
    }
}
