package leetcode.binarysearch;

public class SolutionOffer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 先找行
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (target > matrix[i][0]) {
                // 二分查找
                int left = 0, right = matrix[0].length - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (target > matrix[i][mid]) {
                        left = mid + 1;
                    } else if (target < matrix[i][mid]) {
                        right = mid - 1;
                    } else {
                        return true;
                    }
                }
            } else if (target < matrix[i][0]) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }
}
