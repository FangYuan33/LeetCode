package leetcode.stack;

import java.util.Stack;

public class Solution20 {

    public static void main(String[] args) {
        new Solution20().isValid("(){}}{");
    }
    public boolean isValid(String s) {
        // 左括号进栈，右括号出栈比对是不是对应的左括号
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
