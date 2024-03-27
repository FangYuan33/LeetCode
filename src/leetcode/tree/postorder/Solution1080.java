package leetcode.tree.postorder;

import leetcode.TreeNode;

public class Solution1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean delete = postOrder(root, 0, limit);
        if (delete) {
            return null;
        }

        return root;
    }

    private boolean postOrder(TreeNode node, int s, int limit) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return node.val + s < limit;
        }

        boolean left = postOrder(node.left, s + node.val, limit);
        boolean right = postOrder(node.right, s + node.val, limit);

        if (left) {
            node.left = null;
        }
        if (right) {
            node.right = null;
        }

        return left && right;
    }
}
