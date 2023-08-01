package leetcode.stack;

import java.util.List;
import java.util.Stack;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            // 开始的直接向栈中放
            if (isStart(log)) {
                stack.push(log);
            } else {
                // 找出来一对计算时间
                String left = stack.pop();
                int time = calculate(res, log, left);

                // 如果非空的话，则需要为这个函数减去对应的独占时间
                if (!stack.isEmpty()) {
                    res[Integer.parseInt(stack.peek().split(":")[0])] -= time;
                }
            }
        }

        return res;
    }

    private int calculate(int[] res, String right, String left) {
        String[] rights = right.split(":");
        String[] lefts = left.split(":");

        int time = Integer.parseInt(rights[2]) - Integer.parseInt(lefts[2]) + 1;
        res[Integer.parseInt(rights[0])] += time;

        return time;
    }

    private boolean isStart(String log) {
        return log.contains("start");
    }
}
