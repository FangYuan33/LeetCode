package leetcode.doublepointer;

public class Solution777 {

    public static void main(String[] args) {
        // true
        System.out.println(new Solution777().canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }

    public boolean canTransform(String start, String end) {
        int sIndex = 0, eIndex = 0;
        while (sIndex < start.length() || eIndex < end.length()) {
            while (sIndex < start.length() && start.charAt(sIndex) == 'X') {
                sIndex++;
            }
            while (eIndex < end.length() && end.charAt(eIndex) == 'X') {
                eIndex++;
            }
            if (sIndex == start.length() || eIndex == end.length()) {
                return sIndex == eIndex;
            }
            if (start.charAt(sIndex) != end.charAt(eIndex)) {
                return false;
            }
            if (start.charAt(sIndex) == 'R' && sIndex > eIndex) {
                return false;
            }
            if (start.charAt(sIndex) == 'L' && sIndex < eIndex) {
                return false;
            }
            sIndex++;
            eIndex++;
        }

        return true;
    }
}
