package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Graph;

/**
 * 如果两个顶点能够通过边互相访问到，那么这两个顶点是联通的
 * 该类通过比较某顶点的联通分量ID值来判断两个顶点是否联通
 *
 * @author FangYuan
 * @since 2024-01-28 17:57:34
 */
public class CC {

    private boolean[] marked;

    private int[] id;

    private int count;

    public CC(Graph graph) {
        this.marked = new boolean[graph.V()];
        this.id = new int[graph.V()];
        this.count = 0;

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        if (marked[v]) {
            return;
        }

        marked[v] = true;
        id[v] = count;
        for (Integer w : graph.adj(v)) {
            dfs(graph, w);
        }
    }

    /**
     * 联通分量数
     */
    public int count() {
        return count;
    }

    /**
     * 顶点v和顶点w是否联通
     */
    public boolean connect(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 当前顶点所在的联通分量ID值
     */
    public int id(int v) {
        return id[v];
    }
}
