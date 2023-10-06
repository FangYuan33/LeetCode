package leetcode.doublepointer;

public class Solution809 {

    public static void main(String[] args) {
        System.out.println(new Solution809().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean isStretchy(String origin, String word) {
        int originBegin = 0, originEnd = 0;
        int wordBegin = 0, wordEnd = 0;
        while (originEnd < origin.length() && wordEnd < word.length()) {
            if (origin.charAt(originEnd) != word.charAt(wordEnd)) {
                return false;
            }
            while (originEnd + 1 < origin.length() && origin.charAt(originEnd) == origin.charAt(originEnd + 1)) {
                originEnd++;
            }
            while (wordEnd + 1 < word.length() && word.charAt(wordEnd) == word.charAt(wordEnd + 1)) {
                wordEnd++;
            }
            if (wordEnd - wordBegin > originEnd - originBegin) {
                return false;
            }
            if (wordEnd - wordBegin < originEnd - originBegin && originEnd - originBegin + 1 < 3) {
                return false;
            }
            originBegin = ++originEnd;
            wordBegin = ++wordEnd;
        }

        return originEnd == origin.length() && wordEnd == word.length();
    }

}
