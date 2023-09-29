package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1818 {

    public static void main(String[] args) {
        System.out.println(new Solution1818().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] temp = Arrays.copyOfRange(nums1, 0, nums1.length);
        Arrays.sort(temp);

        long res = 0;
        int n = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int cur = Math.abs(nums1[i] - nums2[i]);
            res += cur;

            int left = 0, right = nums1.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (temp[mid] >= nums2[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (left - 1 >= 0) {
                n = Math.min(n, Math.abs(temp[left - 1] - nums2[i]) - cur);
            }
            if (left < temp.length) {
                n = Math.min(n, Math.abs(temp[left] - nums2[i]) - cur);
            }
        }

        return (int) ((res + n) % ((int) 1e9 + 7));
    }

}
