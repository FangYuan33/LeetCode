package leetcode.doublepointer;

public class Solution777 {

    public static void main(String[] args) {
        // true
        System.out.println(new Solution777().canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }

    public boolean canTransform(String start, String end) {
        int sIndex = 0, eIndex = 0;
        while (sIndex < start.length() && eIndex < end.length()) {
            while (sIndex < start.length() && start.charAt(sIndex) == 'X') {
                sIndex++;
            }
            while (eIndex < end.length() && end.charAt(eIndex) == 'X') {
                eIndex++;
            }
            if (eIndex == end.length() || sIndex == start.length()) {
                return eIndex == sIndex;
            }
            if (end.charAt(eIndex) != start.charAt(sIndex)) {
                return false;
            }
            if (end.charAt(eIndex) == 'L' && start.charAt(sIndex) == 'L' && sIndex < eIndex) {
                return false;
            }
            if (end.charAt(eIndex) == 'R' && start.charAt(sIndex) == 'R' && sIndex > eIndex) {
                return false;
            }
            sIndex++;
            eIndex++;
        }

        return true;
    }
}
