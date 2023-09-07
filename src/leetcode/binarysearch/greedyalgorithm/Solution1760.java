package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution1760 {

    public static void main(String[] args) {
        System.out.println(new Solution1760().minimumSize(new int[]{9}, 2));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);

        int left = 1, right = nums[nums.length - 1];
        while (left < right) {
            int mid = left + right >> 1;

            int op = 0;
            for (int num : nums) {
                if (num > mid) {
                    op += (num - 1) / mid;
                }
            }

            if (op <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
