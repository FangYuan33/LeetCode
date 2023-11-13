package leetcode.tree.bst;

import leetcode.TreeNode;

public class Solution99 {

    TreeNode one = null, two = null;

    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        markNode(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }

    private void markNode(TreeNode node) {
        if (node == null) {
            return;
        }

        markNode(node.left);
        if (pre != null && pre.val >= node.val) {
            if (one == null) {
                one = pre;
            }
            two = node;
        }
        pre = node;
        markNode(node.right);
    }
}
