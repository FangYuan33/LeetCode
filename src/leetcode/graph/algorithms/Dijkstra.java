package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.DirectedEdge;
import leetcode.graph.algorithms.basic.EdgeWeightedDigraph;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Dijkstra 算法，寻找从起点 s 到目的地点 v 的最短路径
 * 无法解决含有负权重边的最短路径问题
 *
 * @author FangYuan
 * @since 2024-02-03 15:34:44
 */
public class Dijkstra {

    static class DistToV implements Comparable<DistToV> {

        private final int v;

        private final double dist;

        public DistToV(int v, double dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(DistToV o) {
            return Double.compare(this.dist, o.dist);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DistToV distToV = (DistToV) o;
            return v == distToV.v && Double.compare(distToV.dist, dist) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, dist);
        }
    }

    /**
     * 记录到达某点 v 的最短边
     */
    private final DirectedEdge[] edgeTo;

    /**
     * 从 s 到达某点 v 的距离
     */
    private final double[] distTo;

    /**
     * 小顶堆，按照边的权重排序
     */
    private final PriorityQueue<DistToV> pq;

    public Dijkstra(EdgeWeightedDigraph digraph, int s) {
        edgeTo = new DirectedEdge[digraph.V()];
        distTo = new double[digraph.V()];
        pq = new PriorityQueue<>();

        for (int i = 0; i < digraph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;

        pq.offer(new DistToV(s, 0));
        while (!pq.isEmpty()) {
            relax(digraph, pq.poll());
        }
    }

    /**
     * 放松边
     * 这意味着检查从 s 到 w 的最短距离是否是先从 s 到 v，然后再由 v 到 w
     * 放松一条边就像将橡皮筋转移到一条更短的路径上，从而缓解了橡皮接的拉力
     */
    private void relax(EdgeWeightedDigraph digraph, DistToV v) {
        for (DirectedEdge edge : digraph.adj(v.v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v.v] + edge.getWeight()) {
                distTo[w] = distTo[v.v] + edge.getWeight();
                edgeTo[w] = edge;
                DistToV distToW = new DistToV(w, distTo[w]);
                pq.remove(distToW);
                pq.offer(distToW);
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hashPathTo(int v) {
        return distTo[v] != Double.MAX_VALUE;
    }

    public Stack<DirectedEdge> pathTo(int v) {
        if (!hashPathTo(v)) return null;

        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge w = edgeTo[v]; w != null; w = edgeTo[w.from()]) {
            path.push(w);
        }
        return path;
    }
}
