package leetcode.doublepointer;

public class Solution125 {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();

        int left = 0, right = lowerCase.length() - 1;
        while (left < right) {
            while (left < lowerCase.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right && lowerCase.charAt(left) != lowerCase.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
