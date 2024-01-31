package leetcode.graph.algorithms.basic;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 加权无向图
 *
 * @author FangYuan
 * @since 2024-01-31 13:15:45
 */
public class EdgeWeightedGraph {

    private final int V;

    private int E;

    private final LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        adj = new LinkedList[v];
        Arrays.fill(adj, new LinkedList<>());
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public LinkedList<Edge> adj(int v) {
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }
}
