package leetcode.tree.recursion;

import leetcode.TreeNode;

public class Solution124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return res;
    }

    private int doMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ans = node.val;
        int left = doMaxPathSum(node.left);
        int right = doMaxPathSum(node.right);
        if (left >= 0) {
            ans += left;
        }
        if (right >= 0) {
            ans += right;
        }
        res = Math.max(res, ans);

        return Math.max(node.val, Math.max(node.val + left, node.val + right));
    }
}
