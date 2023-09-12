package leetcode.slidingwindow;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int cost = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            while (cost > maxCost && left <= right) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(right - left + 1, res);
            right++;
        }

        return res;
    }

}
