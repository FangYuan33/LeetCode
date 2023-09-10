package leetcode.slidingwindow;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int currentCost = 0;

        int left = 0, right = 0;
        while (right < s.length()) {
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            while (left < right && currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            if (currentCost <= maxCost) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }

        return res;
    }

}
