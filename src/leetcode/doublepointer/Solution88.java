package leetcode.doublepointer;

import leetcode.Solution;

public class Solution88 {

    public static void main(String[] args) {
        new Solution88().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int i = 0, j = 0;
        int[] res = new int[m + n];
        while (i < m || j < n) {
            if (i >= m) {
                res[index++] = nums2[j++];
            } else if (j >= n) {
                res[index++] = nums1[i++];
            } else {
                if (nums1[i] <= nums2[j]) {
                    res[index++] = nums1[i++];
                } else {
                    res[index++] = nums2[j++];
                }
            }
        }
        System.arraycopy(res, 0, nums1, 0, res.length);
    }
}
