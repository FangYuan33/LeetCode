package leetcode.dp.backtrack;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        return backtrack(s, 0, p, 0);
    }

    private boolean backtrack(String s, int sIndex, String p, int pIndex) {
        boolean valid = true;
        // 结束条件: 正则表达式匹配完
        if (pIndex == p.length()) {
            // 字符串也匹配完则为成功
            if (sIndex == s.length()) {
                return valid;
            }
        }

        // *的判断 * 要求前边得有个字符才行，所以得加1，此时的正则索引是*的前一个索引
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            // 发生匹配情况
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                // 继续向下判断字符串是否匹配，正则索引不改变
                boolean res1 = backtrack(s, sIndex + 1, p, pIndex);
                // 字符串匹配完了，正则索引 + 2 移动到和正则表达式一样长度，来看看能否匹配成功
                boolean res2 = backtrack(s, sIndex, p, pIndex + 2);
                return res1 || res2;
            }
            // 没有发生匹配的情况
            return backtrack(s, sIndex, p, pIndex + 2);
        }
        // . 和 字符 的匹配逻辑是一样的，都需要向后移动一位索引值来继续匹配
        if (sIndex < s.length() && pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
            return backtrack(s, sIndex + 1, p, pIndex + 1);
        }

        // 字符不等的话返回false
        return !valid;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch("ab", ".*"));
    }
}
