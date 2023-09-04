package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }

            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }

        return res;
    }
}
