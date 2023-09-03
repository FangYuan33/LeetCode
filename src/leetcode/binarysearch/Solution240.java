package leetcode.binarysearch;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (row[0] > target) {
                continue;
            }

            int left = 0, right = row.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (row[mid] > target) {
                    right = mid;
                } else if (row[mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
