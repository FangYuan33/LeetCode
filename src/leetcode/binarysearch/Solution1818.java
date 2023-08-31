package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;
        int[] temp = new int[nums1.length];
        System.arraycopy(nums1, 0, temp, 0, nums1.length);
        Arrays.sort(temp);

        long res = 0;
        int x = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }

            int cur = Math.abs(nums1[i] - nums2[i]);
            res += cur;

            // 在 1 中找与当前 2 值最近似的一个值
            int left = 0, right = temp.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (temp[mid] >= nums2[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (right < temp.length) {
                int big = temp[right];
                int abs = Math.abs(big - nums2[i]);

                x = Math.min(x, abs - cur);
            }

            if (right > 0) {
                int small = temp[right - 1];
                int abs = Math.abs(small - nums2[i]);

                x = Math.min(x, abs - cur);
            }
        }

        return (int) ((res + x) % mod);
    }

}
