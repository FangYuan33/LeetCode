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

    /**
     * 使用深度优先搜索查找有向图中的环
     *
     * @param digraph 有向图
     * @param i       起始顶点
     */
    private void dfs(Digraph digraph, int i) {
        // 如果顶点已标记，则返回
        if (marked[i]) {
            return;
        }

        // 标记当前顶点，并将其加入栈中
        marked[i] = true;
        onStack[i] = true;
        // 遍历当前顶点的相邻顶点
        for (Integer v : digraph.adj(i)) {
            // 如果存在环，则返回
            if (hasCycle()) {
                return;
            }

            // 如果相邻顶点未被标记，则继续深度优先搜索
            if (!marked[v]) {
                edgeTo[v] = i;
                dfs(digraph, v);
            }
            // 如果相邻顶点已被标记且在栈中，则找到了环
            else if (onStack[v]) {
                cycle = new Stack<>();
                for (int j = i; j != v; j = edgeTo[j]) {
                    cycle.push(j);
                }

                cycle.push(v);
                cycle.push(i);
            }
        }
        // 将当前顶点出栈
        onStack[i] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }
}
