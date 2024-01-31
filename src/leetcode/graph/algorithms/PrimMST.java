package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Edge;
import leetcode.graph.algorithms.basic.EdgeWeightedGraph;
import leetcode.graph.algorithms.basic.VToTreeWeight;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Prim 算法-计算加权无向图中的最小生成树
 *
 * @author FangYuan
 * @since 2024-01-31 20:52:57
 */
public class PrimMST {

    /**
     * 权重最小的边
     */
    private Edge[] edgeTo;

    /**
     * edgeTo[w].weight();
     */
    private double[] distTo;

    private boolean[] marked;

    private PriorityQueue<VToTreeWeight> pq;

    public PrimMST(EdgeWeightedGraph graph) {
        edgeTo = new Edge[graph.getV()];
        distTo = new double[graph.getV()];
        marked = new boolean[graph.getV()];
        Arrays.fill(distTo, Double.MAX_VALUE);
        pq = new PriorityQueue<>();

        distTo[0] = 0;
        pq.offer(new VToTreeWeight(0, 0));
        while (!pq.isEmpty()) {
            visit(graph, pq.poll());
        }
    }

    private void visit(EdgeWeightedGraph graph, VToTreeWeight v) {
        // 该点加入树
        marked[v.getV()] = true;
        // 遍历这个点所有的边，把这些边上的另一个点都加入优先队列中
        for (Edge edge : graph.adj(v.getV())) {
            int w = edge.other(v.getV());
            // 如果该点已经加入树了
            if (marked[w]) continue;

            // 如果这个边的权重比之前遍历过的小
            if (edge.weight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                VToTreeWeight vToTreeWeight = new VToTreeWeight(w, edge.weight());
                pq.remove(vToTreeWeight);
                pq.offer(vToTreeWeight);
            }
        }
    }
}
