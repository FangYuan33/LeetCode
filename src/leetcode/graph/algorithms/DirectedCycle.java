package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Digraph;

import java.util.Stack;

/**
 * 判断有向图中是否有环
 *
 * @author FangYuan
 * @since 2024-01-29 21:11:54
 */
public class DirectedCycle {

    private boolean[] marked;

    private int[] edgeTo;

    private Stack<Integer> cycle;

    private boolean[] onStack;

    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.V()];
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];

        for (int i = 0; i < digraph.V(); i++) {
            dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int i) {
        if (marked[i]) {
            return;
        }

        marked[i] = true;
        onStack[i] = true;
        for (Integer v : digraph.adj(i)) {
            if (hasCycle()) {
                return;
            }

            if (!marked[v]) {
                edgeTo[v] = i;
                dfs(digraph, v);
            } else if (onStack[v]) {
                cycle = new Stack<>();
                for (int j = i; j != v; j = edgeTo[j]) {
                    cycle.push(j);
                }

                cycle.push(v);
                cycle.push(i);
            }
        }
        onStack[i] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }
}
