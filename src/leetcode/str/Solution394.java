package leetcode.str;

import java.util.Stack;

public class Solution394 {

    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ']') {
                stack.push(charArray[i]);
            } else if (charArray[i] == ']') {
                StringBuilder element = new StringBuilder();
                String content = getContent(stack);
                int num = getNum(stack);
                while (num != 0) {
                    element.append(content);
                    num--;
                }

                for (char c : element.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    private String getContent(Stack<Character> stack) {
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() != '[') {
            res.insert(0, stack.pop());
        }
        stack.pop();
        return res.toString();
    }

    private int getNum(Stack<Character> stack) {
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
            res.insert(0, stack.pop());
        }
        return Integer.parseInt(String.valueOf(res));
    }

}
