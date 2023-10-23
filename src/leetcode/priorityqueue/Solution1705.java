package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class Solution1705 {

    public static void main(String[] args) {
        // 4
//        System.out.println(new Solution1705().eatenApples(new int[]{2, 1, 10}, new int[]{2, 10, 1}));
        // 7
        System.out.println(new Solution1705().eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }

    static class AppleDay implements Comparable<AppleDay> {

        int appleNum;

        int endDay;

        public AppleDay(int appleNum, int endDay) {
            this.appleNum = appleNum;
            this.endDay = endDay;
        }

        @Override
        public int compareTo(AppleDay o) {
            return this.endDay - o.endDay;
        }
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<AppleDay> appleDays = new PriorityQueue<>();

        int day = 0;
        int res = 0;
        while (day < apples.length || !appleDays.isEmpty()) {
            if (day < apples.length && apples[day] > 0) {
                appleDays.add(new AppleDay(apples[day], day + days[day]));
            }

            while (!appleDays.isEmpty() && day >= appleDays.peek().endDay) {
                appleDays.poll();
            }
            if (!appleDays.isEmpty()) {
                AppleDay appleDay = appleDays.peek();
                appleDay.appleNum--;
                if (appleDay.appleNum == 0) {
                    appleDays.poll();
                }
                res++;
            }
            day++;
        }

        return res;
    }

}
