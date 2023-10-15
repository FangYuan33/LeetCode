package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int cur = 0, index = nums.length - 1;
        while (cur <= sum) {
            cur += nums[index];
            sum -= nums[index];
            res.add(nums[index--]);
        }

        return res;
    }
}
