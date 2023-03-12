package leetcode.stackqueuedeap.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution59 {

}
class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        // 维护一个单调递减的队列
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.size() == 0) {
            return -1;
        } else {
            return maxQueue.peekFirst();
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.removeLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.size() == 0) {
            return -1;
        } else {
            int value = queue.poll();
            if (value == maxQueue.peekFirst()) {
                maxQueue.removeFirst();
            }

            return value;
        }
    }
}
