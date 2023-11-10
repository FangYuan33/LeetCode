package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.*;

public class Solution987 {

    static class TreeNodeIndex implements Comparable<TreeNodeIndex> {

        int x;

        int y;

        TreeNode node;

        public TreeNodeIndex(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }

        @Override
        public int compareTo(TreeNodeIndex o) {
            if (this.y == o.y) {
                if (this.x == o.x) {
                    return this.node.val - o.node.val;
                } else {
                    return this.x - o.x;
                }
            } else {
                return this.y - o.y;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeNodeIndex rootNode = new TreeNodeIndex(0, 0, root);
        Queue<TreeNodeIndex> queue = new LinkedList<>();
        queue.offer(rootNode);
        PriorityQueue<TreeNodeIndex> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(rootNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeIndex node = queue.poll();
                if (node.node.left != null) {
                    TreeNodeIndex left = new TreeNodeIndex(node.x + 1, node.y - 1, node.node.left);
                    priorityQueue.offer(left);
                    queue.offer(left);
                }
                if (node.node.right != null) {
                    TreeNodeIndex right = new TreeNodeIndex(node.x + 1, node.y + 1, node.node.right);
                    priorityQueue.offer(right);
                    queue.offer(right);
                }
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            TreeNodeIndex peek = priorityQueue.peek();
            LinkedList<Integer> element = new LinkedList<>();
            while (!priorityQueue.isEmpty() && priorityQueue.peek().y == peek.y) {
                element.add(priorityQueue.poll().node.val);
            }
            res.add(element);
        }

        return res;
    }
}
