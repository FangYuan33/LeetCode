package leetcode.graph;

import java.util.*;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Graph g = new Graph(graph);
        return g.topological();
    }

    static class Graph {

        private int V;

        private LinkedList<Integer>[] adj;

        // 入度
        private int[] inDegree;

        public Graph(int[][] graph) {
            this.V = graph.length;
            inDegree = new int[V];
            adj = new LinkedList[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }

            // 构造反向图
            for (int i = 0; i < graph.length; i++) {
                for (int v : graph[i]) {
                    adj[v].add(i);
                }
                // 统计入度
                inDegree[i] = graph[i].length;
            }
        }

        // 拓扑排序是找到图中入度为 0 的节点，以及由入度为 0 节点所指向的节点
        public List<Integer> topological() {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            // 入度为 0，则表示该节点为终端节点
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    deque.addLast(i);
                }
            }

            while (!deque.isEmpty()) {
                Integer poll = deque.poll();
                for (Integer w : adj[poll]) {
                    // 将以其为起点的有向边删除，更新终点入度
                    inDegree[w]--;
                    if (inDegree[w] == 0) {
                        deque.addLast(w);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    res.add(i);
                }
            }

            return res;
        }
    }
}
