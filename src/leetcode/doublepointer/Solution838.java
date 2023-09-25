package leetcode.doublepointer;

import java.io.IOException;

public class Solution838 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Solution838().pushDominoes("RR.L"));
    }

    public String pushDominoes(String dominoes) {
        char[] res = dominoes.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '.') {
                char leftChar = i - 1 >= 0 ? res[i - 1] : 'L';
                int right = i + 1;
                while (right < res.length && res[right] == '.') {
                    right++;
                }
                char rightChar = right < res.length ? res[right] : 'R';

                int l = i, r = right - 1;
                if (leftChar == 'R' && rightChar == 'L') {
                    while (l < r) {
                        res[l++] = 'R';
                        res[r--] = 'L';
                    }
                } else if (leftChar == 'R') {
                    while (l <= r) {
                        res[l++] = 'R';
                    }
                } else if (rightChar == 'L') {
                    while (l <= r) {
                        res[l++] = 'L';
                    }
                }
                i = right;
            }
        }

        return new String(res);
    }
}
