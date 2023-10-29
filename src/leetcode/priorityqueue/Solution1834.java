package leetcode.priorityqueue;

import java.util.*;

public class Solution1834 {

    public static void main(String[] args) {
        // 0, 2, 3, 1
        System.out.println(Arrays.toString(new Solution1834().getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
        // 4, 3, 2, 0, 1
//        System.out.println(Arrays.toString(new Solution1834().getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));
    }

    static class IndexProcessTime implements Comparable<IndexProcessTime> {

        int index;

        int beginTime;

        int processTime;

        public IndexProcessTime(int index, int beginTime, int processTime) {
            this.index = index;
            this.beginTime = beginTime;
            this.processTime = processTime;
        }

        @Override
        public int compareTo(IndexProcessTime o) {
            return this.beginTime - o.beginTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        ArrayList<IndexProcessTime> list = new ArrayList<>(tasks.length);
        for (int i = 0; i < tasks.length; i++) {
            list.add(new IndexProcessTime(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(list);
        // taskIndex, processTime
        PriorityQueue<IndexProcessTime> priorityQueue = new PriorityQueue<>((x, y) -> {
            if (x.processTime == y.processTime) {
                return x.index - y.index;
            } else {
                return x.processTime - y.processTime;
            }
        });

        int index = 0;
        int[] res = new int[list.size()];
        int beginTime = 0;
        for (int i = 0; i < list.size() || !priorityQueue.isEmpty(); ) {
            while (i < list.size() && beginTime >= list.get(i).beginTime) {
                IndexProcessTime task = list.get(i++);
                priorityQueue.offer(new IndexProcessTime(task.index, task.beginTime, task.processTime));
            }

            if (!priorityQueue.isEmpty()) {
                IndexProcessTime task = priorityQueue.poll();
                res[index++] = task.index;
                // 增加处理时间
                beginTime += task.processTime;
            } else {
                beginTime = list.get(i).beginTime;
            }
        }

        return res;
    }
}
