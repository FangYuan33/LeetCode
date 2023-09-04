package leetcode.binarysearch;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] <= target && target <= matrix[i][matrix[i].length - 1]) {
                    int left = 0, right = matrix[i].length;
                    while (left < right) {
                        int mid = left + right >> 1;

                        if (matrix[i][mid] == target) {
                            return true;
                        } else if (matrix[i][mid] < target) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }

                    return false;
                }
            }
        }

        return false;
    }
}
