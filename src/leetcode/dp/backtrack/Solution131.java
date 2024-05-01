package leetcode.dp.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aab"));
    }

    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(String s, ArrayList<String> element, int begin) {
        if (begin == s.length()) {
            res.add((List<String>) element.clone());
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            if (isReverse(s.substring(begin, i + 1))) {
                element.add(s.substring(begin, i + 1));
                backtrack(s, element, i + 1);
                // 恢复现场
                element.removeLast();
            }
        }
    }

    private boolean isReverse(String origin) {
        int left = 0, right = origin.length() - 1;
        while (left < right) {
            if (origin.charAt(left) != origin.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
