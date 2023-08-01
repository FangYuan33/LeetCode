package leetcode.stack;

import java.util.Stack;

public class Solution32 {
    public static void main(String[] args) {
        System.out.println(new Solution32().longestValidParentheses("()(()"));
    }

    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int res = 0;
        // 开始位置的索引
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    // 空的话代表目前都是有效的
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start + 1);
                    } else {
                        // 说明有暂未匹配的括号，先把已经匹配的计算一下
                        res = Math.max(res, i - stack.peek());
                    }
                } else {
                    // 空的话证明现在的都是无效的
                    start = i + 1;
                }
            }
        }

        return res;
    }
}
