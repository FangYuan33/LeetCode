package leetcode.tree.bst;

import leetcode.TreeNode;

public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode left = root.left;
        while (left.right != null) {
            left = left.right;
        }
        left.right = root.right;

        return root.left;
    }
}
