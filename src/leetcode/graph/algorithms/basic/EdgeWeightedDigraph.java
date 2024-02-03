package leetcode.graph.algorithms.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 加权有向图
 *
 * @author FangYuan
 * @since 2024-02-03 15:19:54
 */
public class EdgeWeightedDigraph {

    private final int V;

    private int E;

    private LinkedList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public LinkedList<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public List<DirectedEdge> edges() {
        List<DirectedEdge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            list.addAll(adj[v]);
        }
        return list;
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}
