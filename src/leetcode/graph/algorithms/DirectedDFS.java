package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Digraph;

import java.util.List;

/**
 * 有向图的深度优先搜索算法
 *
 * @author FangYuan
 * @since 2024-01-29 20:45:36
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }

    public DirectedDFS(Digraph digraph, List<Integer> sources) {
        marked = new boolean[digraph.V()];
        for (Integer s : sources) {
            if (!marked[s]) {
                dfs(digraph, s);
            }
        }
    }

    private void dfs(Digraph digraph, int s) {
        if (marked[s]) {
            return;
        }

        marked[s] = true;
        for (Integer v : digraph.adj(s)) {
            dfs(digraph, v);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
