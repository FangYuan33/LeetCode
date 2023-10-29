package leetcode.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution871 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution871().minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Arrays.sort(stations, Comparator.comparingInt(x -> x[0]));
        // 保存油量
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);

        int index = 0;
        int res = 0;
        while (startFuel < target) {
            while (index < stations.length && startFuel >= stations[index][0]) {
                priorityQueue.offer(stations[index++][1]);
            }
            if (priorityQueue.isEmpty()) {
                return -1;
            } else {
                startFuel += priorityQueue.poll();
                res++;
            }
        }

        return res;
    }
}
