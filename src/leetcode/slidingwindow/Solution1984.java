package leetcode.slidingwindow;

import java.util.Arrays;

public class Solution1984 {

    public static void main(String[] args) {
        System.out.println(new Solution1984().minimumDifference(new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        int right = k - 1;
        while (right < nums.length) {
            res = Math.min(nums[right] - nums[right - k + 1], res);
            right++;
        }

        return res;
    }
}
