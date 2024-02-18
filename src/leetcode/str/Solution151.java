package leetcode.str;

import java.util.Stack;

public class Solution151 {

    public static void main(String[] args) {
        System.out.println(new Solution151().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] strings = s.split(" ");
        for (String string : strings) {
            if (!"".equals(string)) {
                stack.push(string);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
