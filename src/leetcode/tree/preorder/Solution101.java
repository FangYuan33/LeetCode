package leetcode.tree.preorder;

import leetcode.TreeNode;

public class Solution101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode nod2 = new TreeNode(2);
        TreeNode nod3 = new TreeNode(3);
        TreeNode nod4 = new TreeNode(4);
        TreeNode nod5 = new TreeNode(4);
        TreeNode nod6 = new TreeNode(3);
        root.left = node;
        root.right = nod2;
        node.left = nod3;
        node.right = nod4;
        nod2.left = nod5;
        nod2.right = nod6;

        //
        System.out.println(new Solution101().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return doIsSymmetric(root.left, root.right);
    }

    private boolean doIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean flag1 = doIsSymmetric(left.left, right.right);
        boolean flag2 = doIsSymmetric(left.right, right.left);

        return flag1 && flag2;
    }
}
