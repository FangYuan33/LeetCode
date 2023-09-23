package leetcode.doublepointer;

public class Solution777 {

    public static void main(String[] args) {
        System.out.println(new Solution777().canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }

    public boolean canTransform(String start, String end) {
        int s = 0, e = 0;
        while (s < start.length() || e < end.length()) {
            while (s < start.length() && start.charAt(s) == 'X') {
                s++;
            }
            while (e < end.length() && end.charAt(e) == 'X') {
                e++;
            }
            if (s == start.length() || e == end.length()) {
                return s == e;
            }
            if (start.charAt(s) != end.charAt(e)) {
                return false;
            }
            if (start.charAt(s) == 'L' && s < e) {
                return false;
            }
            if (start.charAt(s) == 'R' && s > e) {
                return false;
            }
            s++;
            e++;
        }

        return true;
    }
}
