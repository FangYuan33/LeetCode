package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int a, int b) {
        // 找每个元素作为最大值满足条件的最左和最右区间边界，然后借助乘法原理来计算个数
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[nums.length];
        Arrays.fill(left, -1);
        int[] right = new int[nums.length];
        Arrays.fill(right, nums.length);

        // 正序遍历找右
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        // 反向遍历找左
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a <= nums[i] && nums[i] <= b) {
                res += (right[i] - i) * (i - left[i]);
            }
        }

        return res;
    }
}
