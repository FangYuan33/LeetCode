package leetcode.doublepointer;

public class Solution125 {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        int left = 0, right = lowerS.length() - 1;

        while (left < right) {
            // 跳过非字母数字
            while (left < right && !Character.isLetterOrDigit(lowerS.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(lowerS.charAt(right))) {
                right--;
            }

            if (left < right) {
                if (lowerS.charAt(left) != lowerS.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
