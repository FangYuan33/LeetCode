package leetcode.doublepointer;

public class Interview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int w1 = -1, w2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1 = i;
            }
            if (words[i].equals(word2)) {
                w2 = i;
            }
            if (w1 != -1 && w2 != -1) {
                res = Math.min(res, Math.abs(w1 - w2));
            }
        }

        return res;
    }
}
