package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution17 {

    String[] numChars = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder element) {
        if (index == digits.length()) {
            res.add(element.toString());
            return;
        }

        char[] charArray = numChars[digits.charAt(index) - '0'].toCharArray();
        for (char c : charArray) {
            element.append(c);
            backtrack(digits, index + 1, element);
            // 恢复现场
            element.deleteCharAt(element.length() - 1);
        }
    }
}
