package leetcode.tree.bst;

import leetcode.TreeNode;

public class Solution230 {

    int k;

    int res;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        midOrder(root);
        return res;
    }

    private void midOrder(TreeNode node) {
        if (node == null || k == 0) {
            return;
        }

        midOrder(node.left);
        k--;
        if (k == 0) {
            res = node.val;
            return;
        }
        midOrder(node.right);
    }
}
