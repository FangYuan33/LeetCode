package leetcode.doublepointer;

public class Interview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int left = -1, right = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                left = i;
            }
            if (words[i].equals(word2)) {
                right = i;
            }
            if (left != -1 && right != -1) {
                res = Math.min(res, Math.abs(left - right));
            }
        }
        return res;
    }
}
