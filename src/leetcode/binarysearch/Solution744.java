package leetcode.binarysearch;

public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + right >> 1;

            if (target > letters[mid]) {
                left = mid + 1;
            } else if (target < letters[mid]) {
                right = mid - 1;
            } else {
                // 找到了开始向后遍历找大于当前的
                left = mid + 1;
                while (left < letters.length) {
                    if (letters[left] > target) {
                        return letters[left];
                    }
                    left++;
                }

                break;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
