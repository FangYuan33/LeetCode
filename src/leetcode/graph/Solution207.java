package leetcode.graph;

import java.util.LinkedList;

public class Solution207 {

    public static void main(String[] args) {
        System.out.println(new Solution207().canFinish(2, new int[][]{new int[]{0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Digraph digraph = new Digraph(numCourses, prerequisites);
        return !digraph.isHasCycle();
    }

    static class Digraph {

        int V;

        private LinkedList<Integer>[] adj;

        private boolean[] marked;

        private boolean[] onStack;

        private boolean hasCycle;

        public Digraph(int v, int[][] prerequisites) {
            hasCycle = false;
            this.V = v;
            marked = new boolean[V];
            onStack = new boolean[V];
            adj = new LinkedList[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }

            for (int[] prerequisite : prerequisites) {
                adj[prerequisite[1]].add(prerequisite[0]);
            }

            for (int i = 0; i < V; i++) {
                dfs(i);
            }
        }

        private void dfs(int v) {
            if (hasCycle) {
                return;
            }

            marked[v] = true;
            onStack[v] = true;
            for (Integer w : adj[v]) {
                if (!marked[w]) {
                    dfs(w);
                } else if (onStack[w]) {
                    hasCycle = true;
                    return;
                }
            }
            onStack[v] = false;
        }

        public boolean isHasCycle() {
            return hasCycle;
        }
    }
}
