package leetcode.doublepointer;

import java.util.Arrays;
import java.util.List;

public class Solution524 {

    public static void main(String[] args) {
        System.out.println(new Solution524().findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((x, y) -> {
            if (x.length() != y.length()) {
                return y.length() - x.length();
            }
            return x.compareTo(y);
        });

        String res = "";
        for (String d : dictionary) {
            if (d.length() > res.length()) {
                int sIndex = 0, dIndex = 0;
                while (dIndex < d.length() && sIndex < s.length()) {
                    if (d.charAt(dIndex) == s.charAt(sIndex)) {
                        dIndex++;
                    }
                    sIndex++;
                }
                if (dIndex == d.length()) {
                    res = d;
                }
            }
        }

        return res;
    }
}
