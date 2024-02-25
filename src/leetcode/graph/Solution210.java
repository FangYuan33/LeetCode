package leetcode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Solution210 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution210().findOrder(2, new int[][]{new int[]{0, 1}, new int[]{1, 0}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 创建有向图
        Digraph digraph = new Digraph(numCourses, prerequisites);
        // 拓扑排序求解
        return digraph.topological();
    }

    static class Digraph {

        // 顶点数
        private final int V;

        // 邻接表
        private final HashSet<Integer>[] adj;

        // 入度
        private final int[] inDegree;

        public Digraph(int numCourses, int[][] prerequisites) {
            this.V = numCourses;
            inDegree = new int[V];
            adj = new HashSet[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new HashSet<>();
            }
            // 初始化邻接表并统计每个顶点的入度
            for (int[] prerequisite : prerequisites) {
                adj[prerequisite[1]].add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }
        }

        /**
         * 拓扑排序：找到图中入度为 0 的顶点，以及由入度为 0 顶点所指向的顶点
         */
        public int[] topological() {
            // 将所有入度为 0 的顶点入队
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    deque.offer(i);
                }
            }

            // 将队列执行出队操作，出队的顺序就是拓扑序
            int index = 0;
            int[] res = new int[V];
            while (!deque.isEmpty()) {
                Integer v = deque.poll();
                for (Integer w : adj[v]) {
                    inDegree[w]--;
                    // 入度为 0 入队
                    if (inDegree[w] == 0) {
                        deque.offer(w);
                    }
                }
                res[index++] = v;
            }

            if (index == res.length) {
                return res;
            }
            return new int[0];
        }
    }
}
