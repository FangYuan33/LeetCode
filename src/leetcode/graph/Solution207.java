package leetcode.graph;

import java.util.LinkedList;

public class Solution207 {

    public static void main(String[] args) {
        System.out.println(new Solution207().canFinish(2, new int[][]{new int[]{0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Digraph digraph = new Digraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (digraph.hasCycle(i)) {
                return false;
            }
        }

        return true;
    }

    static class Digraph {

        int V;

        private LinkedList<Integer>[] adj;

        private int[] marked;

        public Digraph(int v, int[][] prerequisites) {
            this.V = v;
            marked = new int[V];
            adj = new LinkedList[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }

            for (int[] prerequisite : prerequisites) {
                adj[prerequisite[1]].add(prerequisite[0]);
            }
        }

        public boolean hasCycle(int index) {
            return dfs(adj, index);
        }

        private boolean dfs(LinkedList<Integer>[] adj, int index) {
            if (marked[index] == 1) {
                return true;
            }
            if (marked[index] == -1) {
                return false;
            }

            marked[index] = 1;
            for (Integer v : adj[index]) {
                if (dfs(adj, v)) {
                    return true;
                }
            }
            marked[index] = -1;

            return false;
        }
    }
}
