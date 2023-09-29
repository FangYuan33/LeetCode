package leetcode.binarysearch;

public class Solution367 {

    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare(1));
    }

    public boolean isPerfectSquare(int num) {
       long left = 1, right = num;
       while (left <= right) {
           long mid = left + right >> 1;

           if (mid * mid > num) {
               right = mid - 1;
           } else if (mid * mid < num) {
               left = mid + 1;
           } else {
               return true;
           }
       }

       return false;
    }
}
