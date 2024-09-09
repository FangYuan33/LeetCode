package leetcode.backtrack;

import java.util.Arrays;
import java.util.List;

public class Solution139 {
    public static void main(String[] args) {
        System.out.println(new Solution139().wordBreak("bccdbacdbdacddabbaaaadababadad",
                Arrays.asList("cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb",
                        "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a",
                        "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb",
                        "bdb", "ddbdd", "cadaa", "ddbc", "babb")));
    }

    boolean res;

    String s;

    public boolean wordBreak(String s, List<String> wordDict) {
        res = false;
        this.s = s;
        backtrack(wordDict, s);
        return res;
    }

    // 当前问题：拼接单词
    // 每一步的操作：如果当前路径是以某个单词开头的话则去掉
    // 子问题：在路径中去掉拼接上的单词，继续拼接单词
    // 剪枝优化：res == true;
    private void backtrack(List<String> wordDict, String path) {
        if (res) {
            return;
        }
        if (path.isEmpty()) {
            res = true;
            return;
        }

        for (String word : wordDict) {

            if (path.startsWith(word)) {
                backtrack(wordDict, path.substring(word.length()));
            }
        }
    }
}
