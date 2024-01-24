package leetcode.graph;

import java.util.LinkedList;

/**
 * TreMaux 算法记录图中某起点所能经过的点和数量
 *
 * @author FangYuan
 * @since 2024-01-24 21:06:04
 */
public class TreMaux {
    private boolean[] marked;

    private int count;

    public TreMaux(Graph graph, int begin) {
        marked = new boolean[graph.V()];
        dfs(graph, begin);
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        count++;
        LinkedList<Integer> adj = graph.adj(s);
        for (Integer v : adj) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public boolean marked(int w) {
        return marked[w];
    }
}
