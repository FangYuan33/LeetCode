package leetcode.priorityqueue;

import java.util.*;

public class Solution1834 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1834().getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
    }

    static class IndexTask implements Comparable<IndexTask> {

        int index;

        int cost;

        int begin;

        public IndexTask(int index, int cost, int begin) {
            this.index = index;
            this.cost = cost;
            this.begin = begin;
        }

        @Override
        public int compareTo(IndexTask o) {
            return this.begin - o.begin;
        }
    }

    public int[] getOrder(int[][] tasks) {
        IndexTask[] tasksTwo = new IndexTask[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            tasksTwo[i] = new IndexTask(i, tasks[i][1], tasks[i][0]);
        }
        Arrays.sort(tasksTwo);
        PriorityQueue<IndexTask> priorityQueue = new PriorityQueue<>((x, y) -> {
            if (x.cost == y.cost) {
                return x.index - y.index;
            } else {
                return x.cost - y.cost;
            }
        });

        int[] res = new int[tasksTwo.length];
        int beginTime = 1;
        int index = 0;
        for (int i = 0; index < res.length;) {
            while (i < tasksTwo.length && beginTime >= tasksTwo[i].begin) {
                priorityQueue.offer(tasksTwo[i++]);
            }
            if (priorityQueue.isEmpty()) {
                beginTime = tasksTwo[i].begin;
            } else {
                IndexTask task = priorityQueue.poll();
                res[index++] = task.index;
                beginTime += task.cost;
            }
        }

        return res;
    }
}
