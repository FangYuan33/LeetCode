package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {

    public static void main(String[] args) {
//        new Solution18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(new Solution18().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
//        new Solution18().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
//        new Solution18().fourSum(new int[] {2,2,2,2,2}, 8);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 找不到再符合条件的直接结束
            if (target < 0 && nums[i] > 0) {
                break;
            }

            long threeSum = (long) target - (long) nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                // 双指针法
                while (left < right) {
                    long sum = (long) nums[j] + (long) nums[left] + (long) nums[right];

                    if (sum > threeSum) {
                        right--;
                    } else if (sum < threeSum) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                    }

                    while (left > j + 1 && left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
