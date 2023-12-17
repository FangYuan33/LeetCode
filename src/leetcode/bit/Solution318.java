package leetcode.bit;

public class Solution318 {
    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!contains(words[i], words[j])) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }

    private boolean contains(String a, String b) {
        char[] charArray = a.toCharArray();
        for (char c : charArray) {
            if (b.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
