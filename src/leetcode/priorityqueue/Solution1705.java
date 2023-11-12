package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1705 {

    public static void main(String[] args) {
        // 5
        System.out.println(new Solution1705().eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
        // 4
        System.out.println(new Solution1705().eatenApples(new int[]{2, 1, 10}, new int[]{2, 10, 1}));
        // 7
        System.out.println(new Solution1705().eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int res = 0;
        int day = 0;
        while (day < apples.length || !priorityQueue.isEmpty()) {
            if (day < apples.length && apples[day] > 0) {
                priorityQueue.offer(new int[]{apples[day], day + days[day]});
            }
            while (!priorityQueue.isEmpty() && day >= priorityQueue.peek()[1]) {
                priorityQueue.poll();
            }
            if (!priorityQueue.isEmpty()) {
                res++;
                if (--priorityQueue.peek()[0] <= 0) {
                    priorityQueue.poll();
                }
            }
            day++;
        }

        return res;
    }

}
