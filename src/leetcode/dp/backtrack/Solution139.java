package leetcode.dp.backtrack;

import java.util.Arrays;
import java.util.HashSet;
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

    private HashSet<String> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        res = false;
        memo = new HashSet<>();
        backtrack(s, wordDict);
        return res;
    }

    private void backtrack(String s, List<String> wordDict) {
        if (s.length() == 0) {
            res = true;
            return;
        }

        for (String word : wordDict) {
            if (res || memo.contains(s)) {
                break;
            }
            if (s.startsWith(word)) {
                backtrack(s.substring(word.length()), wordDict);
            }
        }
        memo.add(s);
    }
}
