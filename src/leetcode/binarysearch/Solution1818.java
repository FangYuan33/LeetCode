package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1818 {

    public static void main(String[] args) {
        System.out.println(new Solution1818().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int N = (int) (1e9 + 7);
        int[] temp = new int[nums2.length];
        System.arraycopy(nums1, 0, temp, 0, temp.length);
        Arrays.sort(temp);

        int max = 0;
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int cur = Math.abs(nums1[i] - nums2[i]);
            res += cur;
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
                int cur2 = temp[left] - nums2[i];
                max = Math.max(max, cur - cur2);
            }
            if (left - 1 >= 0) {
                int cur2 = nums2[i] - temp[left - 1];
                max = Math.max(max, cur - cur2);
            }

        }

        return (int) ((res - max) % N);
    }

}
