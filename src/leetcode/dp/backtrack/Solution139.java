package leetcode.dp.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution139 {
    public static void main(String[] args) {
        System.out.println(new Solution139().wordBreak("bccdbacdbdacddabbaaaadababadad",
                Arrays.asList("cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb",
                        "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a",
                        "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb",
                        "bdb", "ddbdd", "cadaa", "ddbc", "babb")));
    }

    // 备忘录优化
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict);
    }

    private boolean backtrack(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean ans = false;
        for (int i = 0; i < wordDict.size(); i++) {
            // 学习了新的字符串API
            if (s.startsWith(wordDict.get(i))) {
                boolean res = backtrack(s.substring(wordDict.get(i).length()), wordDict);
                if (res) {
                    ans = true;
                    break;
                }
            }
        }
        memo.put(s, ans);

        return ans;
    }
}
