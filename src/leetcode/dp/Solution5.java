package dp;

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int startIndex = 0, maxLength = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            // 奇数扩展
            int length = expand(charArray, i, i);
            // 偶数扩展
            int length2 = expand(charArray, i, i + 1);

            int max = Math.max(length2, length);
            if (max > maxLength) {
                maxLength = max;
                // 1 - 3/2 = 0;  1 - 4/2 = 0
                startIndex = i - (maxLength - 1) / 2;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    // aba, -1, 3;  1 - ; abba
    private int expand(char[] charArray, int left, int right) {
        while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
