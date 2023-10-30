package leetcode.tree.recursion;

import leetcode.TreeNode;

public class Solution437 {

    int res;

    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        this.res = 0;
        this.targetSum = targetSum;
        doPathSum(root);

        return res;
    }

    private void doPathSum(TreeNode root) {
        if (root == null) {
            return;
        }

        doPathSum2(root, root.val);
        doPathSum(root.left);
        doPathSum(root.right);
    }

    private void doPathSum2(TreeNode root, long val) {
        if (root == null) {
            return;
        }

        if (val == targetSum) {
            res++;
        }
        if (root.left != null) {
            doPathSum2(root.left, val + root.left.val);
        }
        if (root.right != null) {
            doPathSum2(root.right, val + root.right.val);
        }
    }

}
