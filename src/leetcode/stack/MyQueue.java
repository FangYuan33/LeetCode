package leetcode.stack;

import java.util.Stack;

public class MyQueue {

    private final Stack<Integer> left;

    public final Stack<Integer> right;

    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void push(int x) {
        right.push(x);
    }

    public int pop() {
        transfer();
        return left.pop();
    }

    public int peek() {
        transfer();
        return left.peek();
    }

    private void transfer() {
        if (left.isEmpty()) {
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
        }
    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}
