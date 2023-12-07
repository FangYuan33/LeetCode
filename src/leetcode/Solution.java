package leetcode;

import leetcode.doublepointer.Solution18;

import java.util.*;

/**
 * 供本地题解使用
 *
 * @author FangYuan
 * @since 2023-11-14 09:26:23
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            long sum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long s = (long) nums[j] + (long) nums[left] + (long) nums[right];
                    if (s == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                    } else if (s > sum) {
                        right--;
                    } else {
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
