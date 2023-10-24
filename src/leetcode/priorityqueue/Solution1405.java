package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Solution1405 {

    public static void main(String[] args) {
        System.out.println(new Solution1405().longestDiverseString(3, 0, 0));
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
        PriorityQueue<CharNum> charNums = new PriorityQueue<>();
        if (a > 0) {
            charNums.add(new CharNum('a', a));
        }
        if (b > 0) {
            charNums.add(new CharNum('b', b));
        }
        if (c > 0) {
            charNums.add(new CharNum('c', c));
        }

        StringBuilder res = new StringBuilder();
        while (!charNums.isEmpty()) {
            CharNum first = charNums.poll();
            int length = res.length();
            if (length >= 2 && res.charAt(length - 1) == first.c && res.charAt(length - 2) == first.c) {
                CharNum second = charNums.poll();
                if (second == null) {
                    break;
                }
                res.append(second.c);
                if (--second.num > 0) {
                    charNums.offer(second);
                }
                charNums.offer(first);
            } else {
                res.append(first.c);
                if (--first.num > 0) {
                    charNums.offer(first);
                }
            }
        }

        return res.toString();
    }
}
