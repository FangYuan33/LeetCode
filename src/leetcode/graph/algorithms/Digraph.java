package leetcode.graph.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 有向图
 *
 * @author FangYuan
 * @since 2024-01-28 19:38:18
 */
public class Digraph {

    private int V;

    private int E;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        Arrays.fill(adj, new LinkedList<>());
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public Digraph(String path) {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            V = Integer.parseInt(in.readLine());
            E = Integer.parseInt(in.readLine());
            adj = new LinkedList[V];
            Arrays.fill(adj, new LinkedList<>());

            String line;
            while ((line = in.readLine()) != null) {
                String[] edges = line.split(" ");
                addEdge(Integer.parseInt(edges[0]), Integer.parseInt(edges[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(V);

        for (int i = 0; i < digraph.V; i++) {
            for (Integer w : digraph.adj[i]) {
                digraph.addEdge(i, w);
            }
        }

        return digraph;
    }
}
