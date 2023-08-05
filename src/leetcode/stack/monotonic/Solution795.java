package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int a, int b) {
        // 单调递减栈解法，找出 nums[i] 作为区间最大值时，左右两边能达到最远的距离，即碰见大值即停止
        // 注意 如果有重复的值，且这两个值之间没有更大的值时，会发生重复统计的问题，那么这里需要在统计左边或右边的时，要使一边停止住
        int res = 0;
        // 定义左右最大的边界索引值
        int[] left = new int[nums.length];
        Arrays.fill(left, -1);
        int[] right = new int[nums.length];
        Arrays.fill(right, nums.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 碰见大值则不断的出栈，当前索引即为所有出栈元素的最大右边界
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            // 注意这里 = 的边界条件
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        // 计算每个 num 对结果的贡献
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < a || nums[i] > b) {
                continue;
            }
            res += (i - left[i]) * (right[i] - i);
        }

        return res;
    }
}
