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
        for (String element : dictionary) {
            if (element.length() > res.length()) {
                int origin = 0, e = 0;
                while (origin < s.length() && e < element.length()) {
                    if (s.charAt(origin) == element.charAt(e)) {
                        e++;
                    }
                    origin++;
                }
                if (e == element.length()) {
                    res = element;
                }
            } else {
                break;
            }
        }

        return res;
    }
}
