package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curDepth = 2;
        while (!queue.isEmpty()) {
            if (curDepth == depth) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    TreeNode left = new TreeNode(val);
                    left.left = node.left;
                    node.left = left;

                    TreeNode right = new TreeNode(val);
                    right.right = node.right;
                    node.right = right;
                }
                break;
            }
            curDepth++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
