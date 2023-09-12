package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charNum = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            while (charNum.containsKey(s.charAt(right)) && left < right) {
                Integer num = charNum.get(s.charAt(left));
                if (num == 1) {
                    charNum.remove(s.charAt(left));
                } else {
                    charNum.put(s.charAt(left), --num);
                }
                left++;
            }

            res = Math.max(right - left + 1, res);
            charNum.put(s.charAt(right), charNum.getOrDefault(s.charAt(right), 0) + 1);
            right++;
        }

        return res;
    }
}
