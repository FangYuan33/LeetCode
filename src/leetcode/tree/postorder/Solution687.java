package leetcode.tree.postorder;

import leetcode.TreeNode;

public class Solution687 {

    int res;

    public int longestUnivaluePath(TreeNode root) {
        this.res = 0;
        doLongestUnivaluePath(root);
        return res;
    }

    private int doLongestUnivaluePath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int cur = 0;
        int ans = 0;
        int left = doLongestUnivaluePath(node.left);
        int right = doLongestUnivaluePath(node.right);
        if (node.left != null && node.left.val == node.val) {
            ans = left + 1;
            cur = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            cur += right + 1;
            ans = Math.max(ans, right + 1);
        }
        res = Math.max(res, cur);

        return ans;
    }
}
