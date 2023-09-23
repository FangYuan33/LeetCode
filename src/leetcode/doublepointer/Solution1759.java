package leetcode.doublepointer;

public class Solution1759 {
    public int countHomogenous(String s) {
        long res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            res += (long) (right - left + 1) * (right - left) / 2;
            left = right;
        }

        return (int) (res % (int) (1e9 + 7));
    }
}
