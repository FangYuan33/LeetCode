package leetcode.tree;

import leetcode.TreeNode;

public class Solution98 {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}
