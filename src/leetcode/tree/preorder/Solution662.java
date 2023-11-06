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

        // 6
        System.out.println(new Solution662().widthOfBinaryTree(node));
    }

    int res;

    HashMap<Integer, Integer> depthNo;

    public int widthOfBinaryTree(TreeNode root) {
        res = 0;
        depthNo = new HashMap<>();
        preOrder(root, 0, 1);
        return res;
    }

    private void preOrder(TreeNode node, int depth, int no) {
        if (node == null) {
            return;
        }

        if (!depthNo.containsKey(depth)) {
            depthNo.put(depth, no);
        }
        res = Math.max(no - depthNo.get(depth) + 1, res);
        preOrder(node.left, depth + 1, no << 2);
        preOrder(node.right, depth + 1, no << 2 | 1);
    }

}
