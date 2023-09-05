package leetcode.slidingwindow;

public class Solution1446 {
    public int maxPower(String s) {
        int left = 0, right = 0;

        int res = 1;
        while (right < s.length()) {
            while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            res = Math.max(res, right - left + 1);

            right++;
            left = right;
        }

        return res;
    }
}
