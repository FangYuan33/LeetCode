package leetcode.tree;

import leetcode.TreeNode;

public class Solution114 {
    public void flatten(TreeNode root) {
        // 结束条件
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 找到右节点的叶子节点，把左子树接到右节点上
        if (root.right != null) {
            TreeNode rightTree = findRight(root);
            rightTree.right = root.left;
        } else {
            root.right = root.left;
        }
        root.left = null;

        flatten(root.right);
    }

    private TreeNode findRight(TreeNode root) {
        if (root.right == null) {
            return root;
        } else {
            return findRight(root.right);
        }
    }
}
