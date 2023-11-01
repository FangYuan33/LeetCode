package leetcode.tree.recursion;

import leetcode.TreeNode;

import java.util.*;

public class Solution987 {

    static class TreeNodeIndex {

        TreeNode node;

        int x;

        int y;

        public TreeNodeIndex(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNodeIndex newRoot = new TreeNodeIndex(root, 0, 0);
        PriorityQueue<TreeNodeIndex> priorityQueue = new PriorityQueue<>((e1, e2) -> {
            if (e1.y != e2.y) {
                return e1.y - e2.y;
            } else {
                if (e1.x != e2.x) {
                    return e1.x - e2.x;
                } else {
                    return e1.node.val - e2.node.val;
                }
            }
        });
        priorityQueue.offer(newRoot);

        Queue<TreeNodeIndex> queue = new LinkedList<>();
        queue.offer(newRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeIndex node = queue.poll();
                if (node.node.left != null) {
                    TreeNodeIndex nodeIndex = new TreeNodeIndex(node.node.left, node.x + 1, node.y - 1);
                    queue.offer(nodeIndex);
                    priorityQueue.offer(nodeIndex);
                }
                if (node.node.right != null) {
                    TreeNodeIndex nodeIndex = new TreeNodeIndex(node.node.right, node.x + 1, node.y + 1);
                    queue.offer(nodeIndex);
                    priorityQueue.offer(nodeIndex);
                }
            }
        }

        while (!priorityQueue.isEmpty()) {
            ArrayList<Integer> element = new ArrayList<>();
            int y = priorityQueue.peek().y;
            while (!priorityQueue.isEmpty() && priorityQueue.peek().y == y) {
                element.add(priorityQueue.poll().node.val);
            }
            res.add(element);
        }

        return res;
    }
}
