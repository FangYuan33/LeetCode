package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1005 {

    public static void main(String[] args) {
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[]{-4,-2,-3}, 4));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int res = 0;
        if (left > 0) { // 有负数
            if (left >= k) {
                for (int num : nums) {
                    if (k > 0) {
                        res -= num;
                        k--;
                    } else {
                        res += num;
                    }
                }
            } else {
                // 负数太少了
                for (int num : nums) {
                    if (num < 0) {
                        res -= num;
                    } else {
                        res += num;
                    }
                }
                k -= left;
                if (left == nums.length && k % 2 != 0) {
                    res += 2 * nums[left - 1];
                } else if (left < nums.length && nums[left] != 0 && k % 2 != 0) {
                    res -= 2 * Math.min(nums[left], Math.abs(nums[left - 1]));
                }
            }
        } else { // 没有负数
            for (int num : nums) {
                res += num;
            }
            if (k % 2 != 0 && nums[left] != 0) {
                res -= 2 * nums[left];
            }
        }

        return res;
    }
}
