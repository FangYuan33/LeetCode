package leetcode.stackqueuedeap.stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution503().nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }

    public int[] nextGreaterElements(int[] nums) {
        // 维护单调递减栈发现更大的元素
        // 初始化-1 因为最大的值会一直留在栈里解决不了，所以那个位置的索引是出不来的
        // 遍历两次一定能解决问题

        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);

        for (int i = 0; i < length * 2; i++) {
            // 发现大值后弹出对应位置的索引
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                int resIndex = stack.pop();
                res[resIndex] = nums[i % length];
            }
            stack.push(i % length);
        }

        return res;
    }
}
