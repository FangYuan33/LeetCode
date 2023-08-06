package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution907 {
    public int sumSubarrayMins(int[] arr) {
        // 单调递增栈，统计每个元素作为子数组最小元素的贡献次数
        int[] left = new int[arr.length];
        Arrays.fill(left, -1);
        int[] right = new int[arr.length];
        Arrays.fill(right, arr.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (long) arr[i] * (right[i] - i) * (i - left[i]);
        }

        return res > Integer.MAX_VALUE ? (int) (res % 1000000007) : (int) res;
    }
}
