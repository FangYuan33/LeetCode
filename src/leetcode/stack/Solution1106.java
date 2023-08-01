package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1106 {
    public static void main(String[] args) {
        System.out.println(new Solution1106().parseBoolExpr("!(&(f,t))"));
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Character> elements = new Stack<>();
        char[] charArray = expression.toCharArray();

        for (char c : charArray) {
            if (c == '&' || c == '|' || c == '!') {
                operators.push(c);
                // 空格来分隔需要判断的元素
                elements.push(' ');
            } else if (c == '(' || c == ',') {
                continue;
            } else if (c == ')') {
                Character operator = operators.pop();
                ArrayList<Character> temp = new ArrayList<>();
                while (elements.peek() != ' ') {
                    temp.add(elements.pop());
                }
                // 占位符不要了
                elements.pop();

                if (operator == '&') {
                    if (temp.contains('f')) {
                        elements.push('f');
                    } else {
                        elements.push('t');
                    }
                    continue;
                }
                if (operator == '|') {
                    if (temp.contains('t')) {
                        elements.push('t');
                    } else {
                        elements.push('f');
                    }
                    continue;
                }
                if (operator == '!') {
                    Character character = temp.get(0);

                    if (character == 't') {
                        elements.push('f');
                    } else {
                        elements.push('t');
                    }
                }
            } else {
                elements.add(c);
            }
        }

        return elements.get(0) == 't';
    }
}
