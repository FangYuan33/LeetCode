package leetcode.stack;

import java.util.Stack;

public class Solution856 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == ')') {
                // 右括号的话，如果 peek 为 0 那么则是 () 情况 如果不为 0 我们需要把它乘 2
                stack.push(Math.max(1, 2 * stack.pop()));
                // 以上算完之后是单个的元素，如果其中还有其他单个元素的话，则加一起，是 )( 的情况
                if (stack.size() > 1) {
                    stack.push(stack.pop() + stack.pop());
                }
            } else {
                // 左括号的话，需要加入一个 0 来达成 () 的计算
                stack.push(0);
            }
        }

        return stack.peek();
    }
}
