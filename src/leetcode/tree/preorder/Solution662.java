package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.HashMap;

public class Solution662 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.right = node4;

        System.out.println(new Solution662().widthOfBinaryTree(node));
    }

    int res = 0;

    HashMap<Integer, Integer> depthNo;

    public int widthOfBinaryTree(TreeNode root) {
        depthNo = new HashMap<>();
        preOrder(root, 0, 1);
        return res;
    }

    private void preOrder(TreeNode root, int depth, int no) {
        if (root == null) {
            return;
        }

        if (!depthNo.containsKey(depth)) {
            depthNo.put(depth, no);
        }
        res = Math.max(res, no - depthNo.get(depth) + 1);
        preOrder(root.left, depth + 1, no << 1);
        preOrder(root.right, depth + 1, no << 1 | 1);
    }
}
