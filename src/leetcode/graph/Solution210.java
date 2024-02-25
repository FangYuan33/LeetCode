package leetcode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Solution210 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution210().findOrder(2, new int[][]{new int[]{0, 1}, new int[]{1, 0}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Digraph digraph = new Digraph(numCourses, prerequisites);
        return digraph.topological();
    }

    static class Digraph {

        private int V;

        private HashSet<Integer>[] adj;

        private int[] inDegree;

        public Digraph(int numCourses, int[][] prerequisites) {
            this.V = numCourses;
            inDegree = new int[V];
            adj = new HashSet[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new HashSet<>();
            }
            // 初始化邻接表
            for (int[] prerequisite : prerequisites) {
                adj[prerequisite[1]].add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }
        }

        public int[] topological() {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    deque.offer(i);
                }
            }

            int index = 0;
            int[] res = new int[V];
            while (!deque.isEmpty()) {
                Integer v = deque.poll();
                for (Integer w : adj[v]) {
                    inDegree[w]--;
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
