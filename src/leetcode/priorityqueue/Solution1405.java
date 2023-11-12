package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Solution1405 {

    public static void main(String[] args) {
        // ccbc
        System.out.println(new Solution1405().longestDiverseString(0, 1, 3));
    }

    static class CharNum implements Comparable<CharNum> {

        char c;

        int num;

        public CharNum(char c, int num) {
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(CharNum o) {
            return o.num - this.num;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharNum> priorityQueue = new PriorityQueue<>();
        if (a != 0) {
            priorityQueue.offer(new CharNum('a', a));
        }
        if (b != 0) {
            priorityQueue.offer(new CharNum('b', b));
        }
        if (c != 0) {
            priorityQueue.offer(new CharNum('c', c));
        }

        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            CharNum cur = priorityQueue.poll();
            int length = res.length();
            if (length >= 2 && res.charAt(length - 1) == cur.c && res.charAt(length - 2) == cur.c) {
                CharNum two = priorityQueue.poll();
                if (two != null) {
                    res.append(two.c);
                    if (--two.num > 0) {
                        priorityQueue.offer(two);
                    }
                    priorityQueue.offer(cur);
                } else {
                    break;
                }
            } else {
                res.append(cur.c);
                if (--cur.num > 0) {
                    priorityQueue.offer(cur);
                }
            }
        }

        return res.toString();
    }
}
