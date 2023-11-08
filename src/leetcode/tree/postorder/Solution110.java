package leetcode.tree.postorder;

import leetcode.TreeNode;

public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
