package leetcode.tree.postorder;

import leetcode.TreeNode;

public class Solution687 {

    int res;

    public int longestUnivaluePath(TreeNode root) {
        this.res = 0;
        doLongestUnivaluePath(root);
        return res;
    }

    private int doLongestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0, cur = 0;
        int left = doLongestUnivaluePath(root.left);
        int right = doLongestUnivaluePath(root.right);
        if (root.left != null && root.val == root.left.val) {
            ans += left + 1;
            cur += left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            ans = Math.max(ans, right + 1);
            cur += right + 1;
        }
        res = Math.max(res, cur);

        return ans;
    }
}
