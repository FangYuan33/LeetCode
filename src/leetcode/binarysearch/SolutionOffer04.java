package leetcode.binarysearch;

public class SolutionOffer04 {

    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new SolutionOffer04().findNumberIn2DArray(array, 5));
    }

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
            } else if (target == matrix[i][0]) {
                return true;
            }
        }

        return false;
    }
}
