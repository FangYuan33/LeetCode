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

        int res = doPruneTree(root);
        if (res == 0) {
            return null;
        }

        return root;
    }

    private int doPruneTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = doPruneTree(node.left);
        int right = doPruneTree(node.right);

        if (left == 0) {
            node.left = null;
        }
        if (right == 0) {
            node.right = null;
        }

        return node.val + left + right;
    }
}
