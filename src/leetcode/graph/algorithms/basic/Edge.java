package leetcode.graph.algorithms.basic;

public class Edge implements Comparable<Edge> {

    private final int v;

    private final int w;

    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (v == this.v) {
            return w;
        }
        if (v == this.w) {
            return v;
        }
        return -1;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight(), that.weight());
    }
}
