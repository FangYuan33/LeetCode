package leetcode.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15TwoPointer {
    public static void main(String[] args) {
        new Solution15TwoPointer().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序，再使用双指针
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // 特殊情况
        if (nums[0] > 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去重
            int numI = nums[i];
            if (i > 0 && numI == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = numI + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(numI, nums[left], nums[right])));
                    // 指针必要变动
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

                // 去重
                while (left > i + 1 && left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }

        return res;
    }
}
