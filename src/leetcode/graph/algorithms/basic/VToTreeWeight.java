package leetcode.graph.algorithms.basic;

import java.util.Objects;

/**
 * 某个点到树的权重
 *
 * @author FangYuan
 * @since 2024-01-31 20:58:45
 */
public class VToTreeWeight implements Comparable<VToTreeWeight> {

    private final int v;

    private double weight;

    public VToTreeWeight(int v, double weight) {
        this.v = v;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(VToTreeWeight o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VToTreeWeight that = (VToTreeWeight) o;
        return v == that.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, weight);
    }
}
