package leetcode.tree.preorder;

import leetcode.TreeNode;

public class SolutionOffer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left != null && right != null && left.val != right.val) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }

        boolean leftRes = isMirror(left.left, right.right);
        boolean rightRes = isMirror(left.right, right.left);

        return leftRes && rightRes;
    }
}
