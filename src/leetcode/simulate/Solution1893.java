package leetcode.simulate;

public class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean exist = false;
            for (int[] range : ranges) {
                int l = range[0], r = range[1];

                if (l <= i && i <= r) {
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
