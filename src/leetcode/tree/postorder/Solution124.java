package leetcode.tree.postorder;

import leetcode.TreeNode;

public class Solution124 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        System.out.println(new Solution124().maxPathSum(node));
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return res;
    }

    private int doMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int cur = node.val, ans = node.val;
        int left = doMaxPathSum(node.left);
        int right = doMaxPathSum(node.right);
        if (left > 0) {
            cur += left ;
            ans += left;
        }
        if (right > 0) {
            ans = Math.max(ans, node.val + right);
            cur += right;
        }
        res = Math.max(res, cur);

        return ans;
    }
}
