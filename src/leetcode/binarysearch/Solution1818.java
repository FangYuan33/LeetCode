package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1818 {

    public static void main(String[] args) {
        System.out.println(new Solution1818().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int N = (int) 1e9 + 7;
        int[] temp = new int[nums1.length];
        System.arraycopy(nums1, 0, temp, 0, temp.length);
        Arrays.sort(temp);

        long res = 0;
        int num = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }

            int origin = Math.abs(nums1[i] - nums2[i]);
            res += origin;
            int left = 0, right = nums1.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (temp[mid] >= nums2[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 记录最大的变化量
            int n;
            if (left == nums1.length) {
                n = Math.abs(temp[left - 1] - nums2[i]);
            } else if (left == 0) {
                n = Math.abs(temp[0] - nums2[i]);
            } else {
                n = Math.min(Math.abs(temp[left] - nums2[i]), Math.abs(temp[left - 1] - nums2[i]));
            }

            if (n < origin) {
                num = Math.max(origin - n, num);
            }
        }

        return (int) ((res - num) % N);
    }

}
