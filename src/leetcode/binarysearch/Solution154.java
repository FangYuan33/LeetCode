package leetcode.binarysearch;

import java.util.ArrayDeque;

public class Solution154 {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 1, 3};
//        int[] nums = new int[]{1, 3, 5};
//        int[] nums = new int[]{2, 2, 2, 0, 1};
        int[] nums = new int[]{3, 3, 1, 3};
//        int[] nums = new int[]{3, 1, 1};

        System.out.println(new Solution154().findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }
            if (mid - 1 >= 0 && nums[mid - 1] < nums[mid]) {
                right = mid - 1;
                continue;
            }

            int min = nums[left];
            for (int i = left; i <= right; i++) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }

        return -1;
    }
}
