package leetcode.slidingwindow;

public class Solution1446 {

    public static void main(String[] args) {
        System.out.println(new Solution1446().maxPower("cc"));
    }

    public int maxPower(String s) {
        int res = 1;
        char cur = s.charAt(0);
        int left = 0, right = 1;
        while (right < s.length()) {
            if (s.charAt(right) != cur) {
                cur = s.charAt(right);
                left = right;
            }
            res = Math.max(right - left + 1, res);

            right++;
        }

        return res;
    }
}
