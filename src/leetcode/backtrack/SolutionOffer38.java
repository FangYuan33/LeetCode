package leetcode.backtrack;

import java.util.HashSet;
import java.util.Set;

public class SolutionOffer38 {
    // 用于去重
    Set<String> res;
    public String[] permutation(String s) {
        res = new HashSet<>();

        backtrack(new StringBuilder(), s.toCharArray(), new boolean[s.length()]);

        return res.toArray(new String[0]);
    }

    private void backtrack(StringBuilder element, char[] chars, boolean[] visited) {
        // 结束条件
        if (element.length() == chars.length) {
            res.add(element.toString());
            return;
        }

        // 在字符里做选择
        for (int i = 0; i < chars.length; i++) {
            // 使用过直接剪枝
            if (visited[i]) {
                continue;
            }

            element.append(chars[i]);
            visited[i] = true;

            backtrack(element, chars, visited);

            // 回溯完移除
            element.deleteCharAt(element.length() - 1);
            visited[i] = false;
        }
    }
}
