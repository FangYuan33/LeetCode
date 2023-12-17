package leetcode.hashmap;

import java.util.HashMap;

public class Solution299 {
    public String getHint(String secret, String guess) {
        String res = "%dA%dB";
        int a = 0;
        char[] charArray = guess.toCharArray();
        char[] sCharArray = secret.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            if (sCharArray[i] == charArray[i]) {
                a++;
                sCharArray[i] = charArray[i] = ' ';
            }
        }

        int b = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : charArray) {
            if (c != ' ') {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        for (char c : sCharArray) {
            if (charCount.containsKey(c) && charCount.get(c) > 0) {
                b++;
                charCount.put(c, charCount.get(c) - 1);
            }
        }

        return String.format(res, a, b);
    }
}
