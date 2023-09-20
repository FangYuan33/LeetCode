package leetcode.slidingwindow;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            maxCost -= Math.abs(s.charAt(right) - t.charAt(right));

            while (maxCost < 0 && left <= right) {
                maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }

}
