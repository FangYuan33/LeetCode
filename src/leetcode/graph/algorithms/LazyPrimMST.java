package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Edge;
import leetcode.graph.algorithms.basic.EdgeWeightedGraph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 获取加权无向图中最小生成树的Prim算法-延迟移除失效的边版
 *
 * @author FangYuan
 * @since 2024-01-31 13:21:53
 */
public class LazyPrimMST {

    private boolean[] marked;

    // 记录最小生成树的边
    private Queue<Edge> mst;

    // 小顶堆记录所有的边
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph digraph) {
        pq = new PriorityQueue<>();
        marked = new boolean[digraph.getV()];
        mst = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Edge min = pq.poll();

            int e = min.either(), o = min.other(e);
            if (marked[e] && marked[o]) {
                continue;
            }
            mst.offer(min);
            if (!marked[e]) {
                visit(digraph, e);
            }
            if (!marked[o]) {
                visit(digraph, o);
            }
        }
    }

    private void visit(EdgeWeightedGraph digraph, int v) {
        marked[v] = true;
        for (Edge w : digraph.adj(v)) {
            if (!marked[w.other(v)]) {
                pq.offer(w);
            }
        }
    }
}
