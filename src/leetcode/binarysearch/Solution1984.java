package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1984 {

    public static void main(String[] args) {
        System.out.println(new Solution1984().minimumDifference(new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);

        int res = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }

        return res;
    }
}
