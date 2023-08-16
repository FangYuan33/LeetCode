package leetcode.simulate;

import java.util.Arrays;

public class Solution406 {

    public static void main(String[] args) {
        new Solution406().reconstructQueue(new int[][]{new int[]{7, 0}, new int[]{4, 4}, new int[]{7, 1}, new int[]{5, 0}, new int[]{6, 1}, new int[]{5, 2}});
    }

    public int[][] reconstructQueue(int[][] people) {
        // 先根据身高和人数排序
        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });

        // 初始化排队的位置
        int[][] queue = new int[people.length][people[0].length];
        for (int[] p : queue) {
            p[0] = -1;
            p[1] = -1;
        }

        for (int[] person : people) {
            // 开始找位置
            int step = person[1];
            int index = 0;
            // 需要走的条件：步数不为 0 或该位置有人
            while (step != 0 || queue[index][0] != -1) {
                // 该位置没人或者符合大于等于的条件则算一个能占的位置
                if (queue[index][0] == -1 || queue[index][0] >= person[0]) {
                    step--;
                }
                index++;
            }
            queue[index] = person;
        }


        return queue;
    }
}
