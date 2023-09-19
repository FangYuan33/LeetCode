package leetcode.doublepointer;

import java.util.Arrays;

public class Solution611 {
    public int triangleNumber(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);

        int res = 0;
        for (int one = 0; one < nums.length; one++) {
            int two = one + 1;
            while (two <= nums.length - 2) {
                int three = two + 1;
                int sum = nums[one] + nums[two];

                while (three < nums.length && sum > nums[three]) {
                    res++;
                    three++;
                }
                two++;
            }
        }

        return res;
    }
}
