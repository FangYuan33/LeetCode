package leetcode.graph.algorithms.basic;

import java.util.Objects;

/**
 * 有向边
 *
 * @author FangYuan
 * @since 2024-02-03 15:17:14
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedEdge that = (DirectedEdge) o;
        return v == that.v && w == that.w && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, w, weight);
    }

    @Override
    public int compareTo(DirectedEdge o) {
        return Double.compare(this.weight, o.weight);
    }
}
