package leetcode.stack;

import java.util.Stack;

public class Solution1190 {

    public static void main(String[] args) {
        System.out.println(new Solution1190().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }


    public String reverseParentheses(String s) {
        // 思路：左括号也入栈，来限定反转字符串的范围；每碰到右括号则开始反转
        Stack<String> stack = new Stack<>();

        // 标记字符开始的起始索引
        int index = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '(') {
                stack.push(s.substring(i, i + 1));
                i++;
                // 记录字符开始的索引
                index = i;
                // 找到字符结束的索引
                while (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    i++;
                }
                // 字符入栈
                String substring = s.substring(index, i);
                stack.push(substring);
            } else if (s.charAt(i) == ')') {
                StringBuilder pop = new StringBuilder(stack.pop());
                // 有字符的话让它们拼接在一起
                while (!"(".equals(stack.peek())) {
                    pop.insert(0, stack.pop());
                }

                // 反转
                String res = reverseString(pop.toString());
                // 去掉左括号
                stack.pop();

                stack.push(res);
                i++;
            } else {
                // 是字符的话直接入栈
                stack.push(String.valueOf(s.charAt(i++)));
            }
        }

        // 拼接结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    private String reverseString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder res = new StringBuilder();

        for (int i = charArray.length - 1; i >= 0; i--) {
            res.append(charArray[i]);
        }

        return res.toString();
    }
}
