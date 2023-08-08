package leetcode.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序，再使用二分查找的解法，这也是在《算法 第四版》中的解法
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

            // 转换成两数之和求解
            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + i && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = -numI - nums[j];

                // 二分查找
                int left = j + 1, right = nums.length - 1;
                while (left <= right) {
                    int mid = right - ((right - left) >> 1);

                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(numI, nums[j], target)));
                        break;
                    }
                }
            }
        }

        return res;
    }
}
