package leetcode.str;

import java.util.Arrays;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        // 排序找到最小长度的字符串
        Arrays.sort(strs, (x, y) -> x.length() - y.length());
        String min = strs[0];

        for (int i = 0; i < min.length(); i++) {
            char c = min.charAt(i);

            int j = 1;
            while (j < strs.length) {
                if (strs[j].charAt(i) == c) {
                    j++;
                } else {
                    break;
                }
            }

            if (j == strs.length) {
                res.append(c);
            } else {
                break;
            }
        }

        return res.toString();
    }
}
