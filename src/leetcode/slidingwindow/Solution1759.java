package leetcode.slidingwindow;

public class Solution1759 {
    public int countHomogenous(String s) {
        long res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            while (s.charAt(left) != s.charAt(right) && left < right) {
                left++;
            }
            res += right - left + 1;
            right++;
        }

        return (int) (res % (1e9 + 7));
    }
}
