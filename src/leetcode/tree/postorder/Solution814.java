package leetcode.tree.postorder;

import leetcode.TreeNode;
import leetcode.tree.levelorder.Codec;

public class Solution814 {

    public static void main(String[] args) {
        TreeNode treeNode = new Codec().deserialize("1,null,0,0,1");

        new Solution814().pruneTree(treeNode);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        postOrder(root);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    private boolean postOrder(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean left = postOrder(root.left);
        boolean right = postOrder(root.right);

        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }

        return root.val == 1 || left || right;
    }
}
