package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return res;
    }
}
