package leetcode.doublepointer;

import java.util.HashMap;

public class SolutionOffer48 {
    public static void main(String[] args) {
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口 结合hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        // 滑动窗口
        int left = 0, right = 0;
        int res = 0;

        while (right < s.length()) {
            // 有重复
            if (map.containsKey(s.charAt(right))) {
                // 窗口缩小
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            // 没重复
            map.put(s.charAt(right), right);

            res = Math.max(res, right - left + 1);

            // 窗口扩大
            right++;
        }

        return res;
    }
}
