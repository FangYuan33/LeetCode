package leetcode.doublepointer;

import java.io.IOException;

public class Solution838 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Solution838().pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        char[] charArray = dominoes.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.') {
                int left = i - 1, right = i + 1;
                while (right < charArray.length && charArray[right] == '.') {
                    right++;
                }
                i = right;

                char leftChar = left == -1 ? 'L' : charArray[left];
                char rightChar = right == charArray.length ? 'R' : charArray[right];
                left++; right--;
                if (leftChar == 'R' && rightChar == 'L') {
                    while (left < right) {
                        charArray[left++] = 'R';
                        charArray[right--] = 'L';
                    }
                } else if (leftChar == 'R' && rightChar == 'R') {
                    while (left <= right) {
                        charArray[left++] = 'R';
                    }
                } else if (leftChar == 'L' && rightChar == 'L') {
                    while (left <= right) {
                        charArray[left++] = 'L';
                    }
                }
            }
        }

        return new String(charArray);
    }
}
