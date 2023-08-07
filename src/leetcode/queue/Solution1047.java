package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1047 {
    public String removeDuplicates(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (!queue.isEmpty() && queue.peekLast() == c) {
                queue.pollLast();
            } else {
                queue.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }

        return res.toString();
    }
}
