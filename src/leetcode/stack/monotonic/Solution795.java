package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution795 {

    public static void main(String[] args) {
        System.out.println(new Solution795().numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        int[] l = new int[nums.length];
        Arrays.fill(l, -1);
        int[] r = new int[nums.length];
        Arrays.fill(r, nums.length);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                r[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                l[stack.pop()] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left <= nums[i] && nums[i] <= right) {
                res += (r[i] - i) * (i - l[i]);
            }
        }

        return res;
    }
}
