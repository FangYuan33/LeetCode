package leetcode.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution871 {

    public static void main(String[] args) {
        System.out.println(new Solution871().minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }

    static class Station implements Comparable<Station> {

        int distance;

        int fuel;

        public Station(int distance, int fuel) {
            this.distance = distance;
            this.fuel = fuel;
        }

        // 优先去到油量最多的
        @Override
        public int compareTo(Station o) {
            if (this.fuel != o.fuel) {
                return o.fuel - this.fuel;
            } else {
                return this.distance - o.distance;
            }
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0;
        PriorityQueue<Station> priorityQueue = new PriorityQueue<>();
        int stationIndex = 0;
        Arrays.sort(stations, Comparator.comparingInt(x -> x[0]));

        while (startFuel < target) {
            while (stationIndex < stations.length && startFuel >= stations[stationIndex][0]) {
                priorityQueue.offer(new Station(stations[stationIndex][0], stations[stationIndex][1]));
                stationIndex++;
            }
            if (!priorityQueue.isEmpty()) {
                Station station = priorityQueue.poll();
                startFuel += station.fuel;
                res++;
            } else {
                return -1;
            }
        }

        return res;
    }
}
