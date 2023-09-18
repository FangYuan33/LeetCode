package leetcode.doublepointer;

public class Solution481 {
    public int magicalString(int n) {
        // 122...
        if (n <= 3) {
            return 1;
        }

        char[] s = new char[n + 2];
        s[0] = 1;
        s[1] = s[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < n; i++) {
            c ^= 3;
            s[j++] = c;
            if (s[i]== 2) {
                s[j++] = c;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += 2 - s[i];
        }

        return res;
    }
}
