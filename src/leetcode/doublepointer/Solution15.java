package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 答案的结果集
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 第一个数不能比0大
            if (nums[i] > 0) {
                break;
            }
            // 判断重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 定1个，剩下2个用双指针来选
                List<Integer> element = new ArrayList<>();
                element.add(nums[i]);
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 符合条件的答案
                    element.add(nums[left]);
                    element.add(nums[right]);
                    res.add(element);

                    // 去重
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 指针移动
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
