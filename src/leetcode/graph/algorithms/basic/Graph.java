package leetcode.graph.algorithms.basic;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图的邻接表表示法
 *
 * @author FangYuan
 * @since 2024-01-24 20:42:01
 */
public class Graph {

    private int V;

    private int E;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Graph(String path) {
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
        adj[w].add(v);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }
}
