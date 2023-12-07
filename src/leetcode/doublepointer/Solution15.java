package leetcode.doublepointer;

import java.util.*;

public class Solution15 {
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{-1, -1, 0, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

                while (left > i + 1 && left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }

        return res;
    }
}
