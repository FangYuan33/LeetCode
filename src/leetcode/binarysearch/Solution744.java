package leetcode.binarysearch;

public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;

        while (left < right) {
            int mid = left + right >> 1;

            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
