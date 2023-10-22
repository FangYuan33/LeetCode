package leetcode.doublepointer;

public class Solution125 {

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();

        int left = 0, right = lowerCase.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(lowerCase.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(lowerCase.charAt(right))) {
                right--;
            }
            if (lowerCase.charAt(left) != lowerCase.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
