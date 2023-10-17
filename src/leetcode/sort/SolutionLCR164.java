package leetcode.sort;

import java.util.Arrays;

public class SolutionLCR164 {
    public String crackPassword(int[] password) {
        String[] res = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            res[i] = String.valueOf(password[i]);
        }
        Arrays.sort(res, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder builder = new StringBuilder();
        for (String s : res) {
            builder.append(s);
        }

        return builder.toString();
    }
}
