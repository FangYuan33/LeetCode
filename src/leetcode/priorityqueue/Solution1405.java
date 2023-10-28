package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Solution1405 {

    public static void main(String[] args) {
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
        PriorityQueue<CharNum> charNums = new PriorityQueue<>();
        if (a != 0) {
            charNums.offer(new CharNum('a', a));
        }
        if (b != 0) {
            charNums.offer(new CharNum('b', b));
        }
        if (c != 0) {
            charNums.offer(new CharNum('c', c));
        }

        StringBuilder res = new StringBuilder();
        while (!charNums.isEmpty()) {
            CharNum one = charNums.poll();
            int length = res.length();

            if (length >= 2 && res.charAt(length - 1) == one.c && res.charAt(length - 2) == one.c) {
                CharNum two = charNums.poll();
                if (two != null) {
                    res.append(two.c);
                    if (--two.num > 0) {
                        charNums.offer(two);
                    }
                    charNums.offer(one);
                } else {
                    break;
                }
            } else {
                res.append(one.c);
                if (--one.num > 0) {
                    charNums.offer(one);
                }
            }
        }

        return res.toString();
    }
}
