package leetcode.sort;

import java.util.Arrays;

public class SolutionLCR164 {
    public String crackPassword(int[] password) {
        String[] s = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            s[i] = String.valueOf(password[i]);
        }
        Arrays.sort(s, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder res = new StringBuilder();
        for (String e : s) {
            res.append(e);
        }

        return res.toString();
    }
}
