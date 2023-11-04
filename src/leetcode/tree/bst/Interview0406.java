package leetcode.tree.bst;

import leetcode.TreeNode;
import leetcode.tree.levelorder.Codec;

public class Interview0406 {

    public static void main(String[] args) {
        new Interview0406().inorderSuccessor(new Codec().deserialize("5,3,6,2,4,null,null,1"), new TreeNode(1));
    }

    TreeNode pre = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode left = inorderSuccessor(root.left, p);
        if (pre != null && pre.val == p.val) {
            pre = root;
            return root;
        }
        pre = root;
        TreeNode right = inorderSuccessor(root.right, p);

        return left == null ? right : left;
    }
}
