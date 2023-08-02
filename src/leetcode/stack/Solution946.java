package leetcode.stack;

import java.util.Stack;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // pushed 不断的入栈，入栈完成后和 popped 比较，符合的话出栈，最终栈为空即可行
        Stack<Integer> stack = new Stack<>();

        int popIndex = 0;
        for (int i : pushed) {
            stack.push(i);

            while (popIndex < popped.length && !stack.isEmpty() && popped[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
