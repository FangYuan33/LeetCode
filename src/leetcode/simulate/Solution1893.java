package leetcode.simulate;

public class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean exist = false;
            for (int[] range : ranges) {
                int a = range[0], b = range[1];
                if (a <= i && i <= b) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                return false;
            }
        }

        return true;
    }
}
