package leetcode.tree.dfs;

import leetcode.TreeNode;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode rightPre = left;
            while (rightPre.right != null) {
                rightPre = rightPre.right;
            }
            rightPre.right = right;
            root.right = left;
            root.left = null;
        }

        flatten(root.right);
    }


}
