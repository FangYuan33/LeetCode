package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Solution409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            res += entry.getValue() / 2 * 2;
            if (res % 2 == 0 && entry.getValue() % 2 == 1) {
                res++;
            }
        }
        return res;
    }
}
