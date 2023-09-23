package leetcode.doublepointer;

import java.io.IOException;

public class Solution838 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Solution838().pushDominoes("R..."));
    }

    public String pushDominoes(String dominoes) {
        char[] res = dominoes.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '.') {
                int right = i;
                while (right < res.length && res[right] == '.') {
                    right++;
                }

                char leftChar = i - 1 >= 0 ? res[i - 1] : 'L';
                char rightChar = right < res.length ? res[right] : 'R';

                if (leftChar == 'R' && rightChar == 'L') {
                    int l = i, r = right - 1;
                    while (l < r) {
                        res[l++] = 'R';
                        res[r--] = 'L';
                    }
                } else if (leftChar == 'R') {
                    for (int j = i; j < right; j++) {
                        res[j] = 'R';
                    }
                } else if (rightChar == 'L') {
                    for (int j = i; j < right; j++) {
                        res[j] = 'L';
                    }
                }
                i = right;
            }
        }

        return new String(res);
    }
}
