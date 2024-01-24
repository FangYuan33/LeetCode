package leetcode.graph.algorithms;

import java.util.Stack;

/**
 * 该图算法通过记录某节点的父节点来获取从起始点到该点的路径
 *
 * @author FangYuan
 * @since 2024-01-24 21:25:58
 */
public class DepthFirstPaths {

    /**
     * 标记是否能经过
     */
    private boolean[] marked;

    /**
     * 记录父节点
     */
    private int[] edgeTo;

    /**
     * 起点
     */
    private final int s;

    public DepthFirstPaths(Graph graph, int s) {
        this.s = s;
        edgeTo = new int[graph.V()];
        marked = new boolean[graph.V()];

        dfs(graph, s);
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        for (Integer v : graph.adj(s)) {
            if (!marked[v]) {
                edgeTo[v] = s;
                dfs(graph, v);
            }
        }
    }

    public boolean hasPathTo(int s) {
        return marked[s];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);

        return stack;
    }
}
