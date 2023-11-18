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

        int left = doMaxPathSum(node.left);
        int right = doMaxPathSum(node.right);
        int cur = node.val, max = node.val;
        if (left > 0) {
            cur += left;
            max += left;
        }
        if (right > 0) {
            cur += right;
            max = Math.max(max, node.val + right);
        }
        res = Math.max(res, cur);

        return max;
    }
}
