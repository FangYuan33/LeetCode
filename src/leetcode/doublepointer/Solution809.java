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

    private boolean isExpand(String origin, String cur) {
        int oL = 0, oR = 0;
        int cL = 0, cR = 0;
        while (oR < origin.length() && cR < cur.length()) {
            if (origin.charAt(oR) != cur.charAt(cR)) {
                return false;
            }

            while (oR + 1 < origin.length() && origin.charAt(oR) == origin.charAt(oR + 1)) {
                oR++;
            }
            while (cR + 1 < cur.length() && cur.charAt(cR) == cur.charAt(cR + 1)) {
                cR++;
            }

            if (cR - cL > oR - oL) {
                return false;
            }
            if (cR - cL < oR - oL && oR - oL + 1 < 3) {
                return false;
            }
            oR++;
            oL = oR;
            cR++;
            cL = cR;
        }

        return cR == cur.length() && oR == origin.length();
    }

}
