package leetcode.slidingwindow;

import java.util.HashSet;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashSet<Character> mark = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            while (mark.contains(s.charAt(right)) && left < right) {
                mark.remove(s.charAt(left++));
            }
            mark.add(s.charAt(right));
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
