package leetcode.graph;

import leetcode.utils.Matrix;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Solution851 {

    public static void main(String[] args) {
        new Solution851().loudAndRich(Matrix.convert("[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]"), new int[]{3,2,5,4,6,1,7,0});
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Digraph digraph = new Digraph(quiet, richer);
        return digraph.topological();
    }

    static class Digraph {

        private int V;

        private LinkedList<Integer>[] adj;

        private int[] inDegree;

        private int[] quiet;

        public Digraph(int[] quiet, int[][] richer) {
            this.quiet = quiet;
            this.V = quiet.length;
            inDegree = new int[V];
            adj = new LinkedList[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int[] r : richer) {
                adj[r[0]].add(r[1]);
                inDegree[r[1]]++;
            }
        }

        public int[] topological() {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    deque.offer(i);
                }
            }

            int[] res = new int[V];
            for (int i = 0; i < res.length; i++) {
                res[i] = i;
            }
            while (!deque.isEmpty()) {
                Integer w = deque.poll();
                for (Integer m : adj[w]) {
                    inDegree[m]--;
                    if (quiet[res[w]] < quiet[res[m]]) {
                        res[m] = res[w];
                    }
                    if (inDegree[m] == 0) {
                        deque.offer(m);
                    }
                }
            }

            return res;
        }
    }
}
