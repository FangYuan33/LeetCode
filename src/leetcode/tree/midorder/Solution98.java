package leetcode.tree.midorder;

import leetcode.TreeNode;

public class Solution98 {
    // 注意这里指定的是Long的最小值，如果是Integer的最小值则当根节点的值为 Integer.MIN_VALUE 时会出问题
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (pre < root.val) {
            pre = root.val;
        } else {
            return false;
        }

        boolean right = isValidBST(root.right);

        return left && right;
    }
}
