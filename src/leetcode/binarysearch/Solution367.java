package leetcode.binarysearch;

public class Solution367 {

    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num - 1;
        while (left <= right) {
            long mid = left + right >> 1;

            long midNum = mid * mid;
            if (midNum > num) {
                right = mid - 1;
            } else if (midNum < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
