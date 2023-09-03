package leetcode.binarysearch;

public class Solution367 {

    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num + 1;

        while (left < right) {
            int mid = left + right >> 1;

            long val = (long) mid * mid;

            if (val > num) {
                right = mid;
            } else if (val < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
