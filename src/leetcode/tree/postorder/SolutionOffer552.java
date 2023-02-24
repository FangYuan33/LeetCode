package leetcode.tree.postorder;

import leetcode.TreeNode;

public class SolutionOffer552 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = midOrder(root.left);
        int right = midOrder(root.right);
        boolean res = Math.abs(left - right) <= 1;

        return res && isBalanced(root.left) && isBalanced(root.right);
    }

    private int midOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = midOrder(root.left);
        int right = midOrder(root.right);

        return Math.max(left, right) + 1;
    }
}
