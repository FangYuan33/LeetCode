package leetcode.doublepointer;

import java.util.Arrays;

public class Solution16 {

    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        if (nums.length == 3) {
            return res;
        }

        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < 3) {
                break;
            }
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // 双指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return res;
    }
}
