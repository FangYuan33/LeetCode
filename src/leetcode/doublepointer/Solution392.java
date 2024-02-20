package leetcode.doublepointer;

public class Solution392 {

    public boolean isSubsequence(String s, String t) {
        int l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                l++;
            }
            r++;
        }

        return l == s.length();
    }
}
