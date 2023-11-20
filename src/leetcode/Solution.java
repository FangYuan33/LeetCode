package leetcode;

import java.util.*;

/**
 * 供本地题解使用
 *
 * @author FangYuan
 * @since 2023-11-14 09:26:23
 */
public class Solution {
    public int[] getOrder(int[][] tasks) {
        HashMap<int[], Integer> taskNum = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            taskNum.put(tasks[i], i);
        }
        Arrays.sort(tasks, Comparator.comparingInt(x -> x[0]));
        int index = 0;
        int[] res = new int[tasks.length];

        int i = 0, currentTime = tasks[0][0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
            if (x[1] == y[1]) {
                return taskNum.get(x) - taskNum.get(y);
            } else {
                return x[1] - y[1];
            }
        });
        while (i < tasks.length || !priorityQueue.isEmpty()) {
            while (i < tasks.length && currentTime >= tasks[i][0]) {
                priorityQueue.offer(tasks[i++]);
            }
            if (!priorityQueue.isEmpty()) {
                int[] cur = priorityQueue.poll();
                res[index++] = taskNum.get(cur);
                currentTime += cur[1];
            } else if (i < tasks.length) {
                currentTime = tasks[i][0];
            }
        }

        return res;
    }
}
