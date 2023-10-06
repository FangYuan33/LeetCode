package leetcode.doublepointer;

public class Interview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = words.length;
        int word1Index = -1, word2Index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
            }
            if (words[i].equals(word2)) {
                word2Index = i;
            }
            if (word1Index != -1 && word2Index != -1) {
                res = Math.min(res, Math.abs(word1Index - word2Index));
            }
        }
        return res;
    }
}
