package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Graph;

import java.util.*;

/**
 * 广度优先搜索算法
 *
 * @author FangYuan
 * @since 2024-01-28 16:43:41
 */
public class BreadthFirstPaths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;

    public BreadthFirstPaths(Graph graph, int s) {
        this.s = s;
        edgeTo = new int[graph.V()];
        marked = new boolean[graph.V()];

        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        marked[s] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(s);
        while (!queue.isEmpty()) {
            Integer v = queue.pollFirst();

            for (Integer w : graph.adj(v)) {
                if (marked[w]) {
                    continue;
                }
                edgeTo[w] = v;
                marked[w] = true;
                queue.offer(w);
            }
        }
    }

    public boolean havePathTo(int s) {
        return marked[s];
    }

    public Stack<Integer> pathTo(int v) {
        if (!havePathTo(s)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);

        return stack;
    }
}
