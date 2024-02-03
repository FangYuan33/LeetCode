package leetcode.graph.algorithms.basic;

/**
 * 有向边
 *
 * @author FangYuan
 * @since 2024-02-03 15:17:14
 */
public class DirectedEdge {

    private final int v;

    private final int w;

    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }
}
