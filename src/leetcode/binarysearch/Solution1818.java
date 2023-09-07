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
        long sum = 0;
        int max = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum += abs;

            int left = 0, right = temp.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (temp[mid] >= nums2[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left < temp.length) {
                int cur = temp[right] - nums2[i];
                max = Math.max(max, abs - cur);
            }
            if (left - 1 >= 0) {
                int cur2 = nums2[i] - temp[left - 1];
                max = Math.max(max, abs - cur2);
            }
        }

        return (int) ((sum - max) % N);
    }

}
