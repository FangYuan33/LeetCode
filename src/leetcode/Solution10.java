package leetcode;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        return backtrack(s, 0, p, 0);
    }

    private boolean backtrack(String s, int sIndex, String p, int pIndex) {
        // 结束条件: 正则表达式匹配完
        if (pIndex == p.length()) {
            // 字符串也匹配完则为成功
            if (sIndex == s.length()) {
                return true;
            }
        }

        // *的判断 * 要求前边怎么都得有个字符才行所以得加1
        if (pIndex < (p.length() - 1) && p.charAt(pIndex + 1) == '*') {
            // 多个匹配
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                // 不断把字符串 + 1 去核对
                boolean res1 = backtrack(s, sIndex + 1, p, pIndex);
                // 字符串 + 1核对完了，正则表达式往后移动2位看看到没到末尾
                boolean res2 = backtrack(s, sIndex, p, pIndex + 2);
                return res1 || res2;
            }
            // 0个匹配
            return backtrack(s, sIndex, p, pIndex + 2);
        }
        // .的判断
        if (pIndex < p.length() && sIndex < s.length() && p.charAt(pIndex) == '.') {
            return backtrack(s, sIndex + 1, p, pIndex + 1);
        }
        // 字符的判断
        if (pIndex < p.length() && sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) {
            return backtrack(s, sIndex + 1, p, pIndex + 1);
        }

        return false;
    }
}
