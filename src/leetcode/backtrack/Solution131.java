package leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution131 {

    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aab"));
    }

    // 定义全局变量
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        backtrack(s, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(String s, int begin, LinkedList<String> path) {
        // 所有子串均为回文串，添加答案并结束
        if (begin == s.length()) {
            res.add((List<String>) path.clone());
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            String cur = s.substring(begin, i + 1);
            // 每一步的操作：判断是否为回文串，是的话加入路径中，并继续处理子问题
            if (isReverse(cur)) {
                path.add(cur);
                // 子问题：从大于小于等于下标 i + 1 的子数组中判断并构造回文串集合
                backtrack(s, i + 1, path);
                // 恢复现场
                path.removeLast();
            }
        }
    }

    private boolean isReverse(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
