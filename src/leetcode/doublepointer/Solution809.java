package leetcode.doublepointer;

public class Solution809 {

    public static void main(String[] args) {
        System.out.println(new Solution809().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isExpand(s, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean isExpand(String origin, String word) {
        int oL = 0, oR = 0;
        int wL = 0, wR = 0;
        while (oR < origin.length() && wR < word.length()) {
            if (origin.charAt(oR) != word.charAt(wR)) {
                return false;
            }
            while (oR + 1 < origin.length() && origin.charAt(oR) == origin.charAt(oR + 1)) {
                oR++;
            }
            while (wR + 1 < word.length() && word.charAt(wR) == word.charAt(wR + 1)) {
                wR++;
            }
            if (oR - oL < wR - wL) {
                return false;
            }
            if (oR - oL > wR - wL && oR - oL + 1 <= 2) {
                return false;
            }
            oL = ++oR;
            wL = ++wR;
        }

        return oR == origin.length() && wR == word.length();
    }
}
