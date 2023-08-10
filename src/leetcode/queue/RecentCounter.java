package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {

    Deque<Integer> deque;

    public RecentCounter() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        deque.offer(t);

        int left = t - 3000;
        while (!deque.isEmpty() && deque.peek() < left) {
            deque.poll();
        }

        return deque.size();
    }
}
