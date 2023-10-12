package leetcode.sort;

import java.util.Arrays;

public class SolutionLCR164 {
    public String crackPassword(int[] password) {
        String[] p = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            p[i] = String.valueOf(password[i]);
        }
        Arrays.sort(p, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder res = new StringBuilder();
        for (String s : p) {
            res.append(s);
        }

        return res.toString();
    }
}
