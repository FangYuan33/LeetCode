package leetcode.binarysearch;

public class Solution367 {

    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;

        while (left <= right) {
            long mid = left + right >> 1;

            long n = mid * mid;
            if (n > num) {
                right = mid - 1;
            } else if (n < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
