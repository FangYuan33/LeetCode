package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution907 {

    public static void main(String[] args) {
        System.out.println(new Solution907().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        Arrays.fill(left, -1);
        int[] right = new int[arr.length];
        Arrays.fill(right, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
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

        return (int) (res % (int) (1e9 + 7));
    }
}
