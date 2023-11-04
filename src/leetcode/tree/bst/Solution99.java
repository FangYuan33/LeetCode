package leetcode.tree.bst;

import leetcode.TreeNode;

public class Solution99 {

    TreeNode one = null, two = null;

    TreeNode pre;

    public void recoverTree(TreeNode root) {
        midOrder(root);

        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }

    private void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        if (pre != null && pre.val > node.val) {
            if (one == null) {
                one = pre;
            }
            two = node;
        }
        pre = node;
        midOrder(node.right);
    }
}
