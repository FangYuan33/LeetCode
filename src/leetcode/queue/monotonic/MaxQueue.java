package leetcode.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {

    // 两个队列，一个是单调递减栈维护最大值 另一个队列维护所有的元素
    private Deque<Integer> dequeMax;

    private Deque<Integer> dequeNums;

    public MaxQueue() {
        dequeMax = new ArrayDeque<>();
        dequeNums = new ArrayDeque<>();
    }

    public int max_value() {
        if (dequeMax.isEmpty()) {
            return -1;
        } else {
            return dequeMax.peekFirst();
        }
    }

    public void push_back(int value) {
        dequeNums.offer(value);

        while (!dequeMax.isEmpty() && value > dequeMax.peekLast()) {
            dequeMax.pollLast();
        }
        dequeMax.offer(value);
    }

    public int pop_front() {
        if (dequeNums.isEmpty()) {
            return -1;
        } else {
            Integer res = dequeNums.poll();
            if (res.equals(dequeMax.peekFirst())) {
                dequeMax.poll();
            }

            return res;
        }
    }

}
