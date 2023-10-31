package leetcode.tree.midorder;

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

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);

        if (pre != null && pre.val > root.val) {
            if (one == null) {
                one = pre;
            }
            two = root;
        }
        pre = root;

        midOrder(root.right);
    }
}
