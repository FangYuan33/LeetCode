package leetcode.tree;

import leetcode.TreeNode;

public class Solution114 {
    public void flatten(TreeNode root) {
        // 结束条件
        if (root == null) {
            return;
        }

        // 先交换当前节点的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 找到右节点的叶子节点，把左子树接到右节点上
        if (root.right != null) {
            TreeNode rightTree = findRight(root);
            rightTree.right = root.left;
        } else {
            // 右节点为空直接把左子树拿过来即可
            root.right = root.left;
        }
        // 拼接完成后将左子树置空
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
