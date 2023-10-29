package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 多路归并
 *
 * @author FangYuan
 * @since 2023-10-29 14:56:13
 */
public class Multiway {

    public static void main(String[] args) {
        Multiway multiway = new Multiway();
        multiway.merge(new int[][]{{1, 3, 9}, {2, 4, 8}, {5, 6, 7}});
    }

    public void merge(int[][] streams) {
        int N = streams.length;
        // streamIndex, numIndex, num
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        for (int i = 0; i < streams.length; i++) {
            priorityQueue.offer(new int[]{i, 0, streams[i][0]});
        }

        while (!priorityQueue.isEmpty()) {
            int[] min = priorityQueue.poll();
            System.out.println(min[2]);

            if (min[1] + 1 < streams[min[0]].length) {
                priorityQueue.offer(new int[]{min[0], min[1] + 1, streams[min[0]][min[1] + 1]});
            }
        }
    }
}
