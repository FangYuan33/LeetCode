package leetcode.graph.algorithms;

import java.util.Stack;

/**
 * 有向无环图-拓扑排序
 * 拓扑排序的目标是将所有节点排序，使得排在前面的节点不能依赖于排在后面的节点
 * 拓扑排序的顺序即为一个有向无环图的逆后序排序
 *
 * @author FangYuan
 * @since 2024-01-30 12:55:11
 */
public class Topological {

    private Stack<Integer> topologicalOrder;

    public Topological(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder order = new DepthFirstOrder(digraph);
            topologicalOrder = order.reversePost();
        }
    }

    /**
     * 有向无环图？
     */
    public boolean isDAG() {
        // 这个判断好有意思哈哈
        return topologicalOrder != null;
    }

    public Stack<Integer> order() {
        return topologicalOrder;
    }
}
