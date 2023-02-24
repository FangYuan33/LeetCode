package leetcode.tree;

import leetcode.TreeNode;

public class SolutionOffer27 {
    public TreeNode mirrorTree(TreeNode root) {
        doMirror(root);

        return root;
    }

    private void doMirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        doMirror(root.left);
        doMirror(root.right);
    }
}
