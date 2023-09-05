package leetcode.doublepointer;

public class Interview1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] nums = new int[m + n];

        int index = 0;
        int a = 0, b = 0;
        while (a < m || b < n) {
            if (a >= m) {
                nums[index++] = B[b++];
                continue;
            }
            if (b >= n) {
                nums[index++] = A[a++];
                continue;
            }

            if (A[a] <= B[b]) {
                nums[index++] = A[a++];
            } else {
                nums[index++] = B[b++];
            }
        }

        System.arraycopy(nums, 0, A, 0, A.length);
    }

}
