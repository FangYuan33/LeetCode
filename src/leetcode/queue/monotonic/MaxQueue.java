package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {

    Deque<Integer> max;

    Deque<Integer> queue;

    public MaxQueue() {
        max = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }

        return max.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);

        while (!max.isEmpty() && value > max.peekLast()) {
            max.pollLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        Integer res = queue.pollFirst();
        if (res.equals(max.peekFirst())) {
            max.pollFirst();
        }

        return res;
    }

}
