package leetcode.stack;

import java.util.Stack;

public class Solution71 {

    public static void main(String[] args) {
        System.out.println(new Solution71().simplifyPath("/home/"));
    }
    public String simplifyPath(String path) {
        // .. 栈空判断，非空弹栈一个元素
        // . 当前目录不变
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : paths) {
            if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else if (!s.equals("")) {
                stack.push(s);
            }
        }
        // 处理结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}
