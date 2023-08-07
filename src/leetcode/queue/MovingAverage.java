package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    private Deque<Integer> deque;

    private int size;

    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        deque = new ArrayDeque<>();
        sum = 0;
    }

    public double next(int val) {
        sum += val;
        deque.offer(val);

        if (deque.size() > size) {
            sum -= deque.poll();
        }

        return (double) sum / deque.size();
    }
}
