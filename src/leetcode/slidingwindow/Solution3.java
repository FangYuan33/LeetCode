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
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left + 1 == map.size()) {
                res = Math.max(res, right - left + 1);
            }

            while (right - left + 1 > map.size()) {
                Integer num = map.get(s.charAt(left));
                if (num == 0) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), num - 1);
                }
                left++;
            }
            right++;
        }

        return res;
    }
}
